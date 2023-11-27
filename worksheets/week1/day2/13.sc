import data.AliceData

val stopWords: Set[String] = AliceData
  .stopWordText
  .split(AliceData.stopWordRegex)
  .toSet


val words = AliceData
  .bookText
  .split(AliceData.bookRegex)
  .toList


words
  .filterNot(stopWords)
//  .groupBy(identity)
  .groupBy(w => w)
  .view
  .mapValues(g => g.size)
  .toList
  .sortBy(t => t._2)
  .reverse
  .take(10)
  .foreach(println)
