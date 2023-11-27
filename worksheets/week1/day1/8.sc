import annotation.tailrec

def map(xs: List[Int], f: Int => Int): List[Int] = {

  @tailrec
  def loop(xs: List[Int], stack: List[Int]): List[Int] = {
    if (xs == Nil) {
      stack
    }
    else {
      val newStack = f(xs.head) :: stack
      loop(xs.tail, newStack)
    }
  }
  
  loop(xs, Nil).reverse
}


//val xs = List(1, 2, 3, 4)
val xs = (1 to 10000).toList

map(xs, x => x * x)

def square(x: Int): Int = x * x

map(xs, square)
