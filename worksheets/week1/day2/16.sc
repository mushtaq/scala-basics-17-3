import data.Data.books



books
  .foreach(println)


books.filter(b => b.author == "odersky")
  .foreach(println)

books
//  .groupBy(b => b.author)
  .groupBy(_.author)
  .view
//  .mapValues(bs => bs.map(_.basePrice).sum)
  .mapValues(_.map(_.basePrice).sum)
  .foreach(println)


// show all book titles written by odersky
// select title from books where author == "odersky"

books
  .filter(_.author == "odersky")
  .map(_.title)

// write this using collect

