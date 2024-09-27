import java.io.File

fun main() {
    val countOfLetters = parseLettersCount()

    val words = File("src/main/resources/words${countOfLetters}Letter.txt").readLines()

    val result = mutableListOf<String>()

    val selectMode = "Выберите режим:\n" +
            "1 - поиск по множеству букв, 2 - поиск по маске"
    println(selectMode)

    while (true) {
        when (readln()) {
            "1" -> {
                println(
                    "Вы выбрали режим: поиск по множеству букв\n" +
                            "Введите множество букв без пробелов и запятых:"
                )
                searchBySet(words, result)
                break
            }

            "2" -> {
                println("Вы выбрали режим: поиск по маске\n")

                println("Введите строку в формате \"_____\" вместо неизвестных букв указывая '*', например \"а**уз\":")
                searchByMask(words, result, countOfLetters)
                break
            }

            else -> {
                println("Вы выбрали неверный режим, попробуйте снова\n$selectMode")
            }
        }
    }

    println("Если вы хотите исключить буквы из поиска введите их без пробелов и запятых, или просто нажмите \"Enter\":")
    val lettersToExlude = readln().toCharArray().toSet()
    if (lettersToExlude.isNotEmpty()) {
        exludeLetters(lettersToExlude, result)
    }

    if (result.size == 0) {
        println("К сожалению ничего не найдено, попробуйте снова")
    } else {
        result.forEach { println(it) }
        println("Найдено ${result.size} слов")
    }
}

/**
 * Считывает количество букв и возвращает данное число
 * Делает проверку на валидность введеных данных
 * Если данные не валидны просит ввести снова
 */
fun parseLettersCount(): Int {
    while (true) {
        println("Введите длину искомого слова:")
        try {
            val result = readln().toInt()
            if (result <= 18) {
                return result
            } else {
                println("Извините слова длиннее 18 букв мы не ищем, попробуйте снова")

            }
        } catch (e: Exception) {
            println("Вы ввели не число, попробуйте снова")
        }
    }
}

/**
 * Ищет слова по заданной маске
 * Если заданная маска не валидна, просит повторить ввод
 * Возвращает список слов
 */
fun searchByMask(words: List<String>, result: MutableList<String>, countOfLetters: Int) {
    var search: String

    while (true) {
        search = readln()
        if (search.length == countOfLetters) {
            break
        } else {
            println("Вы ввели не $countOfLetters символов, попробуйте снова: ")
        }
    }

    for (word in words) {
        var matches = true
        for (i in 0 until countOfLetters) {
            if (search[i] != '*' && search[i] != word[i]) {
                matches = false
                break
            }
        }
        if (matches) {
            result.add(word)
        }
    }
}

/**
 * Ищет слова по множеству букв
 * Возвращает список слов
 */
fun searchBySet(words: List<String>, result: MutableList<String>) {
    val search: Set<Char> = readln().toCharArray().toSet()

    for (word in words) {
        if (search.all { it in word }) {
            result.add(word)
        }
    }
}

/**
 * Исключает слова по множеству букв
 * Возвращает список слов
 */
fun exludeLetters(lettersToExlude: Set<Char>, words: MutableList<String>) {
    if (lettersToExlude.isNotEmpty()) {
        val iterator = words.iterator()
        while (iterator.hasNext()) {
            val word = iterator.next()
            if (lettersToExlude.any { it in word }) {
                iterator.remove()
            }
        }
    }
}

/**
 * Функция для тестирования
 */
fun searchByMask(words: List<String>, result: MutableList<String>, countOfLetters: Int, search: String) {
    for (word in words) {
        if (word.length != countOfLetters) {
            continue
        }
        var matches = true
        for (i in 0 until countOfLetters) {
            if (search[i] != '*' && search[i] != word[i]) {
                matches = false
                break
            }
        }
        if (matches) {
            result.add(word)
        }
    }
}

/**
 * Функция для тестирования
 */
fun searchBySet(words: List<String>, result: MutableList<String>, search: Set<Char>) {
    for (word in words) {
        if (search.all { it in word }) {
            result.add(word)
        }
    }
}