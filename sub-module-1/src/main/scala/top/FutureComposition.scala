package top

import scala.concurrent.Future

object A {
  import concurrent.ExecutionContext.Implicits.global

  def webServiceCall1(): Future[Int] = Future(10)
//  def webServiceCall2(): Future[Int] = Future(20)
  def webServiceCall2(): Future[Int] = Future(throw new RuntimeException())
  def webServiceCall3(): Future[Int] = Future(30)

  def addAll(): Future[Int] =
    webServiceCall1().flatMap: x =>
      webServiceCall2().flatMap: y =>
        webServiceCall3().map: z =>
          x + y + z

  def addAll2(): Future[Int] =
    val f1 = webServiceCall1()
    val f2 = webServiceCall2()
    val f3 = webServiceCall3()
    for
      x <- f1
      y <- f2
      z <- f3
    yield x + y + z

}

@main
def futureComposition(): Unit =
  ()
