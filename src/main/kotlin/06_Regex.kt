package org.example

/**
 * ============================================================
 * LESSON 6: REGULAR EXPRESSIONS (REGEX)
 * ============================================================
 *
 * This file covers:
 * - Creating Regex patterns
 * - Common patterns
 * - Regex functions
 * - Pattern matching
 * - Replacing with Regex
 * ============================================================
 */

fun main() {
    println("\n" + "═".repeat(60))
    println("  📚  LESSON 6: REGULAR EXPRESSIONS")
    println("═".repeat(60) + "\n")

    val text = "Hello123 World! 456 Kotlin-2026"

    // ============================================================
    // 6.1 CREATING REGEX
    // ============================================================
    println("━━━ 6.1 CREATING REGEX ━━━\n")

    // Method 1: Using Regex class
    val regex1 = Regex("[A-Za-z]+")
    println("  Regex(\"[A-Za-z]+\"): ${regex1.findAll(text).map { it.value }.toList()}")

    // Method 2: Using toRegex()
    val regex2 = "\\d+".toRegex()
    println("  \"\\\\d+\".toRegex(): ${regex2.findAll(text).map { it.value }.toList()}")

    // Method 3: Raw strings (no escaping)
    val regex3 = """\b\w{3}\b""".toRegex()
    println("  \"\"\"\\b\\w{3}\\b\"\"\".toRegex(): ${regex3.findAll(text).map { it.value }.toList()}")

    // ============================================================
    // 6.2 COMMON REGEX PATTERNS
    // ============================================================
    println("\n━━━ 6.2 COMMON REGEX PATTERNS ━━━\n")

    val sample = "Hello World 123 !@# 456 Kotlin 789"
    println("  Sample: \"$sample\"")

    // Letters only
    println("  Letters only: ${sample.split(Regex("[^A-Za-z]+")).filter { it.isNotEmpty() }}")

    // Digits only
    println("  Digits only: ${sample.split(Regex("[^0-9]+")).filter { it.isNotEmpty() }}")

    // Words (alphanumeric + underscore)
    println("  Words: ${sample.split(Regex("[\\w+]")).filter { it.isNotEmpty() }}")

    // Non-letters (your code)
    println("  Non-letters: ${sample.split(Regex("[^A-Za-z]+")).filter { it.isNotEmpty() }}")

    // ============================================================
    // 6.3 REGEX FUNCTIONS
    // ============================================================
    println("\n━━━ 6.3 REGEX FUNCTIONS ━━━\n")

    val sample2 = "The year 2024, month 12, day 31"
    val digitPattern = Regex("\\d+")

    println("  Sample: \"$sample2\"")
    println("  findAll(): ${digitPattern.findAll(sample2).map { it.value }.toList()}")
    println("  findFirst(): ${digitPattern.find(sample2)?.value}")
    println("  findLast(): ${digitPattern.findAll(sample2).lastOrNull()?.value}")
    println("  containsMatchIn(): ${digitPattern.containsMatchIn(sample2)}")
    println("  matches(): ${digitPattern.matches("123")}")
    println("  matches(): ${digitPattern.matches("abc")}")
    println("  matchEntire(): ${digitPattern.matchEntire("123")?.value}")
    println("  matchEntire(): ${digitPattern.matchEntire("123abc")?.value}")

    // ============================================================
    // 6.4 REPLACING WITH REGEX
    // ============================================================
    println("\n━━━ 6.4 REPLACING WITH REGEX ━━━\n")

    val sample3 = "Hello World! Kotlin is awesome."
    println("  Original: \"$sample3\"")
    println("  Replace vowels: ${sample3.replace(Regex("[aeiouAEIOU]"), "*")}")
    println("  Replace consonants: ${sample3.replace(Regex("[bcdfghjklmnpqrstvwxyzBCDFGHJKLMNPQRSTVWXYZ]"), "*")}")
    println("  Replace digits: ${sample3.replace(Regex("\\d"), "*")}")
    println("  Replace whitespace: ${sample3.replace(Regex("\\s"), "_")}")

    // ============================================================
    // 6.5 YOUR CODE: SPLITTING ON NON-LETTERS
    // ============================================================
    println("\n━━━ 6.5 YOUR CODE: SPLITTING ON NON-LETTERS ━━━\n")

    val sentences = listOf(
        "Hello, World! How are you?",
        "Kotlin is great! (or is it?)",
        "123 Main St, City, State 12345"
    )

    sentences.forEach { sentence ->
        val words = sentence.split(Regex("[^A-Za-z]+")).filter { it.isNotEmpty() }
        println("  \"$sentence\"")
        println("    Words: $words")
        println("    Count: ${words.size}")
        println("    Shortest: ${words.minByOrNull { it.length }}")
        println("    Longest: ${words.maxByOrNull { it.length }}")
    }

    // ============================================================
    // 6.6 PRACTICE: REGEX PATTERNS
    // ============================================================
    println("\n━━━ 6.6 PRACTICE: REGEX PATTERNS ━━━\n")

    val testStrings = listOf(
        "email@example.com",
        "john.doe@gmail.com",
        "invalid-email",
        "https://kotlinlang.org",
        "https://example.com/path",
        "12345",
        "abc123"
    )

    // Email pattern
    val emailPattern = Regex("[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}")
    println("  Email Pattern:")
    testStrings.forEach {
        println("    \"$it\": ${emailPattern.matches(it)}")
    }

    // URL pattern (simple)
    val urlPattern = Regex("https?://[A-Za-z0-9.-]+(/[A-Za-z0-9./?=&%]*)?")
    println("\n  URL Pattern:")
    testStrings.forEach {
        println("    \"$it\": ${urlPattern.matches(it)}")
    }

    // Phone number pattern (US)
    val phonePattern = Regex("\\d{3}-\\d{3}-\\d{4}")
    val phoneNumbers = listOf("123-456-7890", "555-123-4567", "1234567890")
    println("\n  Phone Pattern:")
    phoneNumbers.forEach {
        println("    \"$it\": ${phonePattern.matches(it)}")
    }
}