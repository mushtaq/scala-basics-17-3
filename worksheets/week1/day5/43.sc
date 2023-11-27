import tc.implementation.Sorter
import tc.lib.Ord
import tc.app.Book

given Ord[Int] = new Ord[Int] {
  override def compare(a: Int, b: Int): Boolean = a >= b
}

Sorter.sort(List(3, 10, 32, 2, 8, 12))
Sorter.sort(List(Some(10), None, Some(3)))

Sorter.sort(List(3, 10, 32, 2, 8, 12))

Sorter.sort(List("z", "abc", "a", "ss"))
Sorter.sort(List(Some("z"), Some("abc"), None))

// List((1, "xyz"), (3, "abc"), (3, "mno"))
Sorter.sort(List((3, "abc"), (1, "xyz"), (3, "mno")))

Sorter.sort(List(("abc", 3)))

Sorter.sort(data.Data.books).foreach(println)
