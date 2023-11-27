val xs            = 1 :: 2 :: Nil
val a :: b :: Nil = xs

// 8 and List(1, 4, 7, 10, 30)  => List(1, 4, 7, 8, 10, 30)
def insert(x: Int, sortedList: List[Int]): List[Int] = sortedList match {
  case head :: _ if x <= head => x :: sortedList
  case head :: tail           => head :: insert(x, tail)
  case Nil                    => List(x)
}

insert(8, List(1, 4, 7, 10, 30))

// make use if insert
// insert head in a sorted tail
def sort(xs: List[Int]): List[Int] = xs match {
  case head :: tail => insert(head, sort(tail))
  case Nil          => Nil
}

sort(List(3, 10, 32, 2, 8, 12))
