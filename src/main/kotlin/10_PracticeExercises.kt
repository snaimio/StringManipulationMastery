@file:Suppress("Println")

package org.example

/**
 * ============================================================
 * LESSON 10: PRACTICE EXERCISES
 * ============================================================
 *
 * This file contains practice exercises to test your knowledge
 * of string manipulation in Kotlin.
 * ============================================================
 */

fun main() {
    println("\n" + "═".repeat(60))
    println("  📚  LESSON 10: PRACTICE EXERCISES")
    println("═".repeat(60) + "\n")

    // Exercise 1: Count Words
    println("━━━ EXERCISE 1: Count Words ━━━\n")
    println("  Count words in \"The quick brown fox\": ${countWords("The quick brown fox")}")
    println()

    // Exercise 2: Reverse Words
    println("━━━ EXERCISE 2: Reverse Words ━━━\n")
    val original = "Hello Kotlin World"
    println("  Original: \"$original\"")
    println("  Reversed: \"${reverseWords(original)}\"")
    println()

    // Exercise 3: Find Longest Word
    println("━━━ EXERCISE 3: Find Longest Word ━━━\n")
    val sample = "The quick brown fox jumps over the lazy dog"
    println("  Text: \"$sample\"")
    println("  Longest: \"${findLongestWord(sample)}\"")
    println()

    // Exercise 4: Count Vowels
    println("━━━ EXERCISE 4: Count Vowels ━━━\n")
    val vowelText = "Hello World"
    println("  Text: \"$vowelText\"")
    println("  Vowel count: ${countVowels(vowelText)}")
    println()

    // Exercise 5: Is Palindrome
    println("━━━ EXERCISE 5: Is Palindrome ━━━\n")
    println("  \"racecar\" is palindrome: ${isPalindrome("racecar")}")
    println("  \"hello\" is palindrome: ${isPalindrome("hello")}")
    println()

    // Exercise 6: Character Occurrences
    println("━━━ EXERCISE 6: Character Occurrences ━━━\n")
    val charText = "Hello World"
    println("  Text: \"$charText\"")
    val counts = countCharacterOccurrences(charText)
    counts.forEach { (char, count) ->
        println("    '$char': $count")
    }
    println()

    // Exercise 7: Find All Positions
    println("━━━ EXERCISE 7: Find All Positions ━━━\n")
    val findText = "hello world hello"
    val findSub = "hello"
    println("  Text: \"$findText\"")
    println("  Substring: \"$findSub\"")
    // ✅ Using function from SharedUtils
    val positions = findAllOccurrences(findText, findSub)
    println("  Positions: $positions")
    println()

    // Exercise 8: Title Case
    println("━━━ EXERCISE 8: Title Case ━━━\n")
    val titleText = "the quick brown fox"
    println("  Original: \"$titleText\"")
    println("  Title Case: \"${toTitleCase(titleText)}\"")
    println()

    // Exercise 9: Remove Duplicates
    println("━━━ EXERCISE 9: Remove Duplicates ━━━\n")
    val dupText = "hello world hello kotlin world"
    println("  Original: \"$dupText\"")
    println("  No duplicates: \"${removeDuplicates(dupText)}\"")
    println()

    // Exercise 10: Process String
    println("━━━ EXERCISE 10: Process String ━━━\n")
    processString("The QUICK brown FOX jumps over the LAZY dog")
}

// ============================================================
// EXERCISE FUNCTIONS
// ============================================================

fun countWords(text: String): Int {
    return text.split(Regex("[^A-Za-z]+"))
        .filter { it.isNotEmpty() }
        .size
}

fun reverseWords(text: String): String {
    return text.split(" ").joinToString(" ") { it.reversed() }
}

fun findLongestWord(text: String): String? {
    return text.split(Regex("[^A-Za-z]+"))
        .filter { it.isNotEmpty() }
        .maxByOrNull { it.length }
}

fun countVowels(text: String): Int {
    return text.lowercase().count { it in "aeiou" }
}

fun isPalindrome(text: String): Boolean {
    val cleaned = text.filter { it.isLetterOrDigit() }.lowercase()
    return cleaned == cleaned.reversed()
}

fun countCharacterOccurrences(text: String): Map<Char, Int> {
    return text.filter { it.isLetter() }
        .groupingBy { it.lowercaseChar() }
        .eachCount()
}

fun toTitleCase(text: String): String {
    return text.split(Regex("[^A-Za-z]+"))
        .filter { it.isNotEmpty() }
        .joinToString(" ") { word ->
            word.replaceFirstChar { it.uppercase() }
        }
}

fun removeDuplicates(text: String): String {
    return text.split(Regex("[^A-Za-z]+"))
        .filter { it.isNotEmpty() }
        .distinct()
        .joinToString(" ")
}

fun processString(text: String) {
    println("  Original: \"$text\"")
    println("  Lowercase: \"${text.lowercase()}\"")
    println("  Uppercase: \"${text.uppercase()}\"")
    println("  Word count: ${text.wordCount()}")
    println("  Shortest word: ${text.shortestWord()}")
    println("  Longest word: ${text.longestWord()}")
    println("  Vowel count: ${text.countVowels()}")
    println("  Consonant count: ${text.consonantCount}")
    println("  Reversed: \"${text.reversed()}\"")
    println("  Title Case: \"${toTitleCase(text)}\"")
}

// ============================================================
// ❌ REMOVED - Duplicate! Now in SharedUtils
// ============================================================
// fun findAllOccurrences(text: String, sub: String): List<Int> {
//     val result = mutableListOf<Int>()
//     var index = text.indexOf(sub)
//     while (index != -1) {
//         result.add(index)
//         index = text.indexOf(sub, index + 1)
//     }
//     return result
// }