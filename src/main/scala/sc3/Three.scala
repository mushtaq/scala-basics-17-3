package sc3

@main
def three(): Unit =

  lazy val x = {
    println("I am lazy val")
    10
  }

  def y = {
    println("I am def")
    20
  }

  val z = {
    println("I am val")
    30
  }

  println(x + y + z)
  println(x + y + z)
  println(x + y + z)
  println(x + y + z)
  println(x + y + z)
