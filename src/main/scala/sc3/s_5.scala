package sc3

@main
def five(): Unit =

  val xs = List(1, 2, 3)
  val ys = List("a", "b")
  val zs = List(7.9, 4.3)

  // multiple xs with ys  ==> (1 -> "a"), (1 -> "b")... (3 -> "b")

  val pairs: List[List[(Int, String)]] =
    xs.map: x =>
      ys.map: y =>
        x -> y

  println(pairs)
  println(pairs.flatten)

  val pairs2: List[(Int, String)] =
    xs.flatMap: x =>
      ys.map: y =>
        x -> y

  println(pairs2)

  val tuple3: List[(Int, String, Double)] =
    xs.flatMap: x =>
      ys.flatMap: y =>
        zs.map: z =>
          (x, y, z)

  println(tuple3)

  val tuple3_with_for =
    for
      x <- xs
      if x > 1
      y <- ys
      if y.length < x
      z <- zs
      if z != x
    yield (x, y, z)

  println(tuple3_with_for)
