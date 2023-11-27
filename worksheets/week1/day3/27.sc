

def length[T](xs: List[T]): Int = {
  if(xs.isEmpty) 0 else 1 + length(xs.tail)
}

length(List(1, 2, 3))


//def reverse[T](xs: List[T]): List[T] = {
//
//}

