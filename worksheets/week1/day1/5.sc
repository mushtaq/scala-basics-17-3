import scala.collection.mutable

def map(xs: List[Int], f: Int => Int) = {
  val it = xs.iterator
  val result: mutable.Buffer[Int] = mutable.Buffer()

  while (it.hasNext) {
    val x = it.next()
    val y = f(x)
    result.append(y)
  }

  result
}


val xs = List(1, 2, 3, 4)

map(xs, x => x * x)

def square(x: Int): Int = x * x

map(xs, square)
