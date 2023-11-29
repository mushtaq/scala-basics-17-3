
//def square(x: Int) = x * x

val square: Int => Int = x => x * x

square(9)

val divide10By: Function1[Int, Double] =
  case x if x != 0 => 10/x

val pDivide10By: PartialFunction[Int, Double] =
  case x if x != 0 => 10/x

divide10By(2)
divide10By(5)

pDivide10By(2)
pDivide10By(5)

pDivide10By.isDefinedAt(2)
pDivide10By.isDefinedAt(5)
pDivide10By.isDefinedAt(0)
