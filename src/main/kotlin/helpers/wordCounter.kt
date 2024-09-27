package helpers

import java.io.File

fun main() {
    val start = System.currentTimeMillis()

    val letterCount = mutableMapOf<Char, Int>()
    for (i in 3..18) {
        val file = "src/main/resources/words${i}Letter.txt"

        val list = File(file).readLines()

        for (word in list) {
            val wordArr = word.toCharArray()
            for (letter in wordArr) {
                letterCount[letter] = letterCount.getOrDefault(letter, 0) + 1
            }
        }
    }

    val end = System.currentTimeMillis()

    println(end - start)


    val sortedLetterCount = letterCount.entries.sortedByDescending { it.value }.associate { it.toPair() }

    val result = sortedLetterCount.toList().joinToString("\n")

    val outputFile = File("src/main/resources/letterCount.txt")

    outputFile.writeText(result)
    println(System.currentTimeMillis() - start)
}