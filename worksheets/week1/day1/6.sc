import annotation.tailrec

//@tailrec
def map(xs: List[Int], f: Int => Int): List[Int] = {
  if(xs == Nil) {
    xs
  }
  else {
    f(xs.head) :: map(xs.tail, f)
  }
}


//val xs = List(1, 2, 3, 4)
val xs = (1 to 1000).toList

map(xs, x => x * x)

def square(x: Int): Int = x * x

map(xs, square)
