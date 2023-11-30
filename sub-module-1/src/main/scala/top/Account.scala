package top

import java.util.concurrent.Executors
import scala.concurrent.duration.DurationInt
import scala.concurrent.{Await, ExecutionContext, Future}

// Unmesh Joshi: Singular Update Queue
// ActiveObject
// Actor like behaviour
class Account:
  private val executorService = Executors.newSingleThreadExecutor(Thread.ofVirtual().factory())
  given ExecutionContext      = ExecutionContext.fromExecutorService(executorService)

  private var balance = 0

  def deposit(amount: Int): Future[Unit] = Future:
    balance += amount

  def getBalance(): Future[Int] = Future:
    balance

  def stop(): Unit = executorService.shutdown()

@main
def accountRun1() =
  val account = new Account

  extension [T](f: Future[T]) def block(): T = Await.result(f, 2.seconds)

//  val executorService    = Executors.newFixedThreadPool(1000)
  val executorService    = Executors.newVirtualThreadPerTaskExecutor()
  given ExecutionContext = ExecutionContext.fromExecutorService(executorService)

  val ops: List[Future[Future[Unit]]] =
    (1 to 100000).toList.map: x =>
      // this operation puts task in the queue
      Future:
        account.deposit(1)

  val op: Future[List[Unit]] =
    val futures: List[Future[Unit]] = ops.map(_.flatten)
    Future.sequence(futures)

  op.block()
  println(account.getBalance().block())

  account.stop()
  executorService.shutdown()
  ()
