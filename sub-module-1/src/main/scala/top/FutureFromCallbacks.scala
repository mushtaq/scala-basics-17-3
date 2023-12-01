package top

import scala.concurrent.duration.DurationInt
import scala.concurrent.{Await, Future, Promise}


// how to convert a callback into value so that we can compose those values
object B {
  import concurrent.ExecutionContext.Implicits.global

  def task(): Future[Int] =
    val p = Promise[Int]()
    new Thread(() => {
      Thread.sleep(5000)
      def compute: Int = 10
      p.success(compute)
      ()
    }).start()
    p.future

}

@main
def futureFromCallbacks(): Unit =
  import concurrent.ExecutionContext.Implicits.global

  extension [T](f: Future[T]) def block(): T = Await.result(f, 10.seconds)

  println("started running")

  val f1 = B.task()
  val f2 = B.task()

  val f: Future[Int] = for
    x <- f1
    y <- f2
  yield
    x + y

  println(f.block())
  ()
