import data.AliceData

val stopWords = AliceData
  .stopWordText
  .split(AliceData.stopWordRegex)


val words = AliceData
  .bookText
  .split(AliceData.bookRegex)

val f1: String => Boolean = w => w.length > 14
words.filter(f1)

words.maxBy(w => w.length)


val text = "a123:b123:c123"

text.split(":")





