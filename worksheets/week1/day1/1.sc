
val xs: List[Int] = List(1, 2, 3, 4)
// List<int> xs = List(1, 2, 3, 4)

val ys = xs.map(x => x + 10)

xs

ys


val zs = 0 :: xs

xs

def square(x: Int): Int = x * x
// int square(int x) {
//   return x * x
// }

square(9)

xs.map(square)

//////////////////////

def map(xs: List[Int], f: Int => Int): List[Int] = {
  ???
}

// Array<int> map(Array<int> xs, Function f) {
//
//}