package sc3

@main
def eight(): Unit =
  enum Day:
    case Workday, Weekend

  enum Customer:
    case Regular
    case Reward

  enum Color:
    case Red
    case Blue
    case Green
    case Custom(value: Int)

  enum Option[+T]:
    case None
    case Some(value: T)

  enum List[+T]:
    case Nil
    case Cons(head: T, tail: List[T])

  Day.valueOf("Workday")
  Day.Workday
  Day.values

  ()
