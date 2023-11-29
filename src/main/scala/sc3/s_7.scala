package sc3

@main
def seven(): Unit =
  val xs = List(1, 2, 3, 4)
  // square all the elements greater than 2

  println {
    xs
      .filter(x => x > 2)
      .map(x => x * x)
  }

  println {
    for
      x <- xs
      if x > 2
    yield x * x
  }

  println {
    xs.collect:
      case x if x > 2 => x * x
  }

  val pf: PartialFunction[Int, Int] =
    case x if x > 2 => x * x

  println {
    xs
      .filter(pf.isDefinedAt)
      .map(pf)
  }

  ()
