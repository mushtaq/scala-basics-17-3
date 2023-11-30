val x: String | Int = if true then "abc" else 100

class Book

def handle(input: String | Int) = input match
  case x: Book    =>
  case x: String =>
  case x: Int    =>


