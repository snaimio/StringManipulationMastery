package org.example

/**
 * ============================================================
 * LESSON 4: SEARCHING & CHECKING
 * ============================================================
 *
 * This file covers:
 * - contains() method
 * - startsWith() / endsWith()
 * - indexOf() / lastIndexOf()
 * - any() / all() / none()
 * - Checking character types
 * ============================================================
 */

fun main() {
    println("\n" + "═".repeat(60))
    println("  📚  LESSON 4: SEARCHING & CHECKING")
    println("═".repeat(60) + "\n")

    val text = "The quick brown fox jumps over the lazy dog"

    // ============================================================
    // 4.1 CONTAINS
    // ============================================================
    println("━━━ 4.1 CONTAINS ━━━\n")

    println("  Text: \"$text\"")
    println("  contains(\"fox\"): ${text.contains("fox")}")
    println("  contains(\"cat\"): ${text.contains("cat")}")
    println("  contains(\"The\"): ${text.contains("The")}")
    println("  contains(\"the\"): ${text.contains("the")}")
    println("  contains(\"the\", ignoreCase = true): ${text.contains("the", ignoreCase = true)}")
    println("  contains('x'): ${text.contains('x')}")
    println("  contains('z'): ${text.contains('z')}")

    // ============================================================
    // 4.2 STARTSWITH / ENDSWITH
    // ============================================================
    println("\n━━━ 4.2 STARTSWITH / ENDSWITH ━━━\n")

    println("  Text: \"$text\"")
    println("  startsWith(\"The\"): ${text.startsWith("The")}")
    println("  startsWith(\"the\"): ${text.startsWith("the")}")
    println("  startsWith(\"the\", ignoreCase = true): ${text.startsWith("the", ignoreCase = true)}")
    println("  endsWith(\"dog\"): ${text.endsWith("dog")}")
    println("  endsWith(\"cat\"): ${text.endsWith("cat")}")
    println("  endsWith(\"Dog\"): ${text.endsWith("Dog")}")
    println("  endsWith(\"dog\", ignoreCase = true): ${text.endsWith("dog", ignoreCase = true)}")

    // ============================================================
    // 4.3 INDEXOF / LASTINDEXOF
    // ============================================================
    println("\n━━━ 4.3 INDEXOF / LASTINDEXOF ━━━\n")

    println("  Text: \"$text\"")
    println("  indexOf(\"fox\"): ${text.indexOf("fox")}")
    println("  indexOf(\"the\"): ${text.indexOf("the")}")
    println("  indexOf(\"the\", ignoreCase = true): ${text.indexOf("the", ignoreCase = true)}")
    println("  lastIndexOf(\"the\"): ${text.lastIndexOf("the")}")
    println("  lastIndexOf(\"the\", ignoreCase = true): ${text.lastIndexOf("the", ignoreCase = true)}")
    println("  indexOf(\"x\"): ${text.indexOf('x')}")
    println("  indexOf(\"z\"): ${text.indexOf('z')}")
    println("  indexOf(\"fox\", 15): ${text.indexOf("fox", 15)}") // Start searching from index 15

    // ============================================================
    // 4.4 ANY / ALL / NONE
    // ============================================================
    println("\n━━━ 4.4 ANY / ALL / NONE ━━━\n")

    val samples = listOf(
        "Hello123",
        "HelloWorld",
        "123456",
        "Hello!",
        "   "
    )

    samples.forEach { sample ->
        println("  \"$sample\":")
        println("    any { it.isDigit() }: ${sample.any { it.isDigit() }}")
        println("    all { it.isLetter() }: ${sample.all { it.isLetter() }}")
        println("    all { it.isLetterOrDigit() }: ${sample.all { it.isLetterOrDigit() }}")
        println("    none { it.isDigit() }: ${sample.none { it.isDigit() }}")
        println("    any { it.isUpperCase() }: ${sample.any { it.isUpperCase() }}")
    }

    // ============================================================
    // 4.5 CHECKING CHARACTER TYPES (YOUR CODE)
    // ============================================================
    println("\n━━━ 4.5 CHECKING CHARACTER TYPES ━━━\n")

    val strings = listOf(
        "Hello World",
        "Paper",
        "Windy"
    )

    strings.forEach { str ->
        println("  \"$str\":")
        println("    First char: '${str.first()}'")
        println("    Is letter: ${str.first().isLetter()}")
        println("    Is digit: ${str.first().isDigit()}")
        println("    Is uppercase: ${str.first().isUpperCase()}")
        println("    Is lowercase: ${str.first().isLowerCase()}")
        println("    Is whitespace: ${str.first().isWhitespace()}")
    }

    // ============================================================
    // 4.6 PRACTICE: DOES FIRST LETTER EXIST (YOUR CODE)
    // ============================================================
    println("\n━━━ 4.6 PRACTICE: DOES FIRST LETTER EXIST ━━━\n")

    val str1 = "Hello World"
    val str2 = "Paper"
    val str3 = "Windy"

    println("  First string: \"$str1\"")
    println("  Second string: \"$str2\"")
    println("  Using contains(): ${doesFirstLetterExist(str1, str2)}")
    println("  Without contains(): ${doesFirstLetterNoContainsExist(str1, str2)}")
    println()

    println("  First string: \"$str1\"")
    println("  Second string: \"$str3\"")
    println("  Using contains(): ${doesFirstLetterExist(str1, str3)}")
    println("  Without contains(): ${doesFirstLetterNoContainsExist(str1, str3)}")

    // ============================================================
    // 4.7 PRACTICE: FIND ALL OCCURRENCES
    // ============================================================
    println("\n━━━ 4.7 PRACTICE: FIND ALL OCCURRENCES ━━━\n")

    val searchText = "hello world hello kotlin hello"
    val searchWord = "hello"

    println("  Text: \"$searchText\"")
    println("  Searching for: \"$searchWord\"")
    println("  All occurrences at: ${findAllOccurrences(searchText, searchWord)}")
    println("  Occurrence count: ${countOccurrences(searchText, searchWord)}")
}

fun doesFirstLetterExist(first: String, second: String): Boolean {
    if (second.isEmpty()) return false
    val firstCharOfSecond = second[0]
    return first.contains(firstCharOfSecond, ignoreCase = true)
}

fun doesFirstLetterNoContainsExist(first: String, second: String): Boolean {
    if (second.isEmpty()) return false
    val firstCharOfSecond = second[0]
    for (char in first) {
        if (char.equals(firstCharOfSecond, ignoreCase = true)) {
            return true
        }
    }
    return false
}

fun findAllOccurrences(text: String, sub: String): List<Int> {
    val result = mutableListOf<Int>()
    var index = text.indexOf(sub)
    while (index != -1) {
        result.add(index)
        index = text.indexOf(sub, index + 1)
    }
    return result
}

fun countOccurrences(text: String, sub: String): Int {
    return findAllOccurrences(text, sub).size
}