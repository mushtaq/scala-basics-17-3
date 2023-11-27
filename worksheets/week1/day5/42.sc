//import tc.implementation.Sorter

//Sorter.sort(List(3, 10, 32, 2, 8, 12))
//Sorter.sort2(List("z", "abc", "a", "ss"))


def m[T](x: T): Class[_] = x.getClass

m(123)
m("abc")
m(tc.app.Book("oderky", "scala", 100))

m[Int](123)
m[String]("abc")
m[tc.app.Book](tc.app.Book("oderky", "scala", 100))

"abc" <= "xyz"