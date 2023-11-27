
val xs: List[Int] = List(1, 2, 3, 4)

//method
def square(x: Int): Int = x * x
// int square(int x) {
//   return x * x
// }

//function
val squareF: Int => Int = square
val squareF2: Function1[Int, Int] = square

squareF.apply(9)
squareF2.apply(9)

//square.apply(9) // won't work
square(9)

squareF(9)
squareF.apply(9)

xs.map(square)

