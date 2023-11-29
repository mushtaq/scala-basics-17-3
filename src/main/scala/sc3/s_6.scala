package sc3

@main
def six(): Unit =
  val xO = Option(10)
  val yO = Option("a")
  val zO = Option.empty[Double]

  println(xO)
  println(xO.map(x => x * x))
  println(xO.filter(x => x > 6))
  println(xO.filter(x => x > 16))

  val resultO: Option[(Int, String)] =
    xO.flatMap: x =>
      yO.map: y =>
        (x, y)

  println(resultO)
  resultO.foreach(println)

  val resultO2: Option[(Int, String)] =
    for
      x <- xO
      y <- yO
    yield (x, y)

  println(resultO2)
  resultO2.foreach(println)
