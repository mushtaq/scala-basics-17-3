
def map(xs: List[Int], f: Int => Int): List[Int] = {
  val it = xs.iterator
  var stack: List[Int] = List()

  while (it.hasNext) {
    val x = it.next()
    val y = f(x)
    stack = y :: stack
  }

  stack.reverse
}


val xs = List(1, 2, 3, 4)

map(xs, x => x * x)

def square(x: Int): Int = x * x

map(xs, square)
