package org.example

/**
 * ============================================================
 * SHARED UTILITIES
 * ============================================================
 *
 * This file contains all shared extension functions and utilities
 * used across all lessons.
 * ============================================================
 */

// ============================================================
// DOUBLE EXTENSIONS
// ============================================================

fun Double.format(digits: Int): String {
    return "%.${digits}f".format(this)
}

// ============================================================
// STRING EXTENSIONS
// ============================================================

fun String.wordCount(): Int {
    return this.split(Regex("[^A-Za-z]+"))
        .filter { it.isNotEmpty() }
        .size
}

fun String.shortestWord(): String? {
    return this.split(Regex("[^A-Za-z]+"))
        .filter { it.isNotEmpty() }
        .minByOrNull { it.length }
}

fun String.longestWord(): String? {
    return this.split(Regex("[^A-Za-z]+"))
        .filter { it.isNotEmpty() }
        .maxByOrNull { it.length }
}

fun String.averageWordLength(): Double {
    val words = this.split(Regex("[^A-Za-z]+")).filter { it.isNotEmpty() }
    return if (words.isEmpty()) 0.0 else words.map { it.length }.average()
}

fun String.isPalindrome(): Boolean {
    val cleaned = this.filter { it.isLetter() }.lowercase()
    return cleaned == cleaned.reversed()
}

fun String.containsLetter(char: Char): Boolean {
    return this.contains(char, ignoreCase = true)
}

fun String.removeVowels(): String {
    return this.replace(Regex("[aeiouAEIOU]"), "")
}

fun String.removeConsonants(): String {
    return this.replace(Regex("[bcdfghjklmnpqrstvwxyzBCDFGHJKLMNPQRSTVWXYZ]"), "")
}

fun String.reverseWords(): String {
    return this.split(" ")
        .map { it.reversed() }
        .joinToString(" ")
}

fun String.countVowels(): Int {
    return this.lowercase().count { it in "aeiou" }
}

fun String.findShortestWord(): String? {
    val words = this.split(Regex("[^A-Za-z]+")).filter { it.isNotEmpty() }
    return if (words.isEmpty()) null else words.minByOrNull { it.length }
}

fun String.doesFirstLetterExist(other: String): Boolean {
    if (other.isEmpty()) return false
    return this.contains(other[0], ignoreCase = true)
}

fun String.isValidEmail(): Boolean {
    val pattern = Regex("[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}")
    return pattern.matches(this)
}

// ❌ Commented out - not used anywhere
// fun String.isValidPhoneNumber(): Boolean {
//     val pattern = Regex("\\d{3}-\\d{3}-\\d{4}")
//     return pattern.matches(this)
// }

// ============================================================
// MORE EXTENSION FUNCTIONS
// ============================================================

fun String.containsDigit(): Boolean {
    return this.any { it.isDigit() }
}

fun String.containsUpperCase(): Boolean {
    return this.any { it.isUpperCase() }
}

fun String.containsLowerCase(): Boolean {
    return this.any { it.isLowerCase() }
}

fun String.toCamelCase(): String {
    val words = this.split(Regex("[^A-Za-z]+")).filter { it.isNotEmpty() }
    if (words.isEmpty()) return this
    return words.first().lowercase() + words.drop(1).joinToString("") {
        it.replaceFirstChar { c -> c.uppercase() }
    }
}

fun String.toSnakeCase(): String {
    return this.split(Regex("[^A-Za-z]+"))
        .filter { it.isNotEmpty() }
        .joinToString("_") { it.lowercase() }
}

fun String.removeSpaces(): String {
    return this.replace(" ", "")
}

// ============================================================
// VALIDATION EXTENSIONS
// ============================================================

val String.vowelCount: Int
    get() = this.count { it in "aeiouAEIOU" }

val String.consonantCount: Int
    get() = this.count { it.isLetter() && it !in "aeiouAEIOU" }

val String.isAllLetters: Boolean
    get() = this.all { it.isLetter() }

val String.isAllDigits: Boolean
    get() = this.all { it.isDigit() }

// ============================================================
// ANAGRAM CHECKER
// ============================================================

fun areAnagrams(str1: String, str2: String): Boolean {
    val clean1 = str1.filter { it.isLetter() }.lowercase()
    val clean2 = str2.filter { it.isLetter() }.lowercase()
    return clean1.toCharArray().sorted() == clean2.toCharArray().sorted()
}