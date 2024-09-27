import kotlin.test.Test
import kotlin.test.assertEquals

class SolverTests {

    @Test
    fun testSearchBySet() {
        val words = listOf("арбуз", "банан", "груша", "яблоко")
        val result = mutableListOf<String>()
        val search = "абзур".toCharArray().toSet()

        searchBySet(words, result, search)

        val expected = listOf("арбуз")
        assertEquals(expected, result)
    }

    @Test
    fun testSearchByMask1() {
        val words = listOf("аргус", "абрикос", "алмаз", "аэропорт")
        val result = mutableListOf<String>()
        val countOfLetters = 5
        val search = "а**уз"

        searchByMask(words, result, countOfLetters, search)

        val expected = listOf<String>()
        assertEquals(expected, result)
    }

    @Test
    fun testSearchByMask2() {
        val words = listOf("аргус", "абрикос", "алмаз", "аэропорт")
        val result = mutableListOf<String>()
        val countOfLetters = 5
        val search = "а****"

        searchByMask(words, result, countOfLetters, search)

        val expected = listOf("аргус", "алмаз")
        assertEquals(expected, result)
    }

    @Test
    fun testExludeLetters() {
        val words = mutableListOf("аргус", "абрикос", "алмаз", "аэропорт")
        val lettersToExclude = setOf('р', 'о')

        exludeLetters(lettersToExclude, words)

        val expected = listOf("алмаз")
        assertEquals(expected, words)
    }
}

