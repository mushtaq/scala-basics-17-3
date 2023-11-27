package tc.implementation

import tc.lib.Ord

object Sorter:
  def sort[T: Ord](xs: List[T]): List[T] = xs match
    case head :: tail => insert(head, sort(tail))
    case Nil          => Nil

  def insert[T: Ord](x: T, sortedList: List[T]): List[T] = sortedList match
    case head :: _ if x <= head => x :: sortedList
    case head :: tail           => head :: insert(x, tail)
    case Nil                    => List(x)
