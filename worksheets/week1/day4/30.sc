
val a: Option[Int] = Some(10)
//val a: Option[Int] = None
val b: Option[Int] = Some(20)
//val b: Option[Int] = None

// Some(10) + None => Some(10)

def add(x: Option[Int], y: Option[Int]): Option[Int] = {
  if(x.isEmpty)
    y
  else
    Some(a.get + y.get)
}

val t = (Some(10), None)

def add2(x: Option[Int], y: Option[Int]): Option[Int] = {
  (x, y) match {
    case (None, _) => y
    case (_, None) => x
    case (None, None) => None
    case (Some(m), Some(n)) => Some(m + n)
  }
}

def add2(x: Option[Int], y: Option[Int]): Option[Int] = {
  (x, y) match {
    case (gg: None.type, _) => y
    case (_, None) => x
//    case (None, gg: None.type ) => None
    case (Some(m), gg: Some[Int]) => Some(m + gg.value)
  }
}

//add(a, b)

//val f: Option[Int] = None

//a.get
//f.get
