package helpers

import java.io.File

fun main() {
//    val inputFile = File("src/main/resources/wordsAlphabetical.txt")
//    val words = inputFile.readLines().map { it.split("\t") }.map { it.first() }
//    val outputFile = File("src/main/resources/wordsAlphabetical.txt")
//
//    outputFile.writeText(words.joinToString("\n"))

    val startTime = System.currentTimeMillis()

    val inputFile = File("src/main/resources/wordsAlphabetical.txt")
    val words = inputFile.readLines()

    for (i in 3..18) {
        val outputFile = "src/main/resources/words${i}Letter.txt"

        val set1 = File(outputFile).readLines().toSet()
        val set2 = words.filter { it.length == i }.toSet()

        val result = set1.union(set2).toList().sorted().joinToString("\n")

        File(outputFile).writeText(result)
    }

    val endTime = System.currentTimeMillis()
    println(endTime-startTime)
}