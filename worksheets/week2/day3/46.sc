val pf: PartialFunction[Int, Int] =
  case x if x > 2 => x * x

val pf2: PartialFunction[Int, Int] =
  case x if x < 2 => x * x

val pf3 = pf.orElse(pf2)

pf.isDefinedAt(3)
pf.isDefinedAt(1)

pf2.isDefinedAt(1)
pf2.isDefinedAt(3)

pf3.isDefinedAt(1)
pf3.isDefinedAt(3)

pf(1)
pf2(3)

pf3(1)
pf3(3)

pf3: PartialFunction[Int, Int]
pf3: Function1[Int, Int]
pf3: (Int => Int)

