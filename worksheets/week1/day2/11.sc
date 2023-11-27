import data.AliceData

val stopWords: Set[String] = AliceData
  .stopWordText
  .split(AliceData.stopWordRegex)
  .toSet


val words = AliceData
  .bookText
  .split(AliceData.bookRegex)

words.filter(w => !stopWords.contains(w))

words.filterNot(w => stopWords.contains(w))
words.filterNot(w => stopWords.apply(w))
words.filterNot(w => stopWords(w))

val p: String => Boolean = stopWords.contains


words.filterNot(w => stopWords.contains(w))
words.filterNot(p)

words.filterNot(stopWords.apply)

val p2: String => Boolean = stopWords
words.filterNot(stopWords)
