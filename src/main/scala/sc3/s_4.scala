package sc3

@main
def four(): Unit =
  lazy val lazy_x = {
    println("I am lazy val")
    10
  }

  def def_y = {
    println("I am def")
    20
  }

  val val_z = {
    println("I am val")
    30
  }

  // a and c are call by value semantics
  // b is call by name semantics
  // b is now call by need semantics ===> this is the default in haskell
  def run(a: Int, b: => Int, c: Int): Unit =
    lazy val b2 = b
    println(a + b2 + c)
    println(a + b2 + c)

  // lazy_x and val_z are first evaluated and then passed as arguments
  // but y is passed by name/or reference to the method itself
  run(lazy_x, def_y, val_z)
