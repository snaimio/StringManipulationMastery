package org.example

/**
 * ============================================================
 * LESSON 5: TRANSFORMATION
 * ============================================================
 *
 * This file covers:
 * - map() / mapNotNull()
 * - filter() / filterNot()
 * - groupBy()
 * - distinct() / distinctBy()
 * - sorted() / sortedBy()
 * ============================================================
 */

fun main() {
    println("\n" + "═".repeat(60))
    println("  📚  LESSON 5: TRANSFORMATION")
    println("═".repeat(60) + "\n")

    val text = "The quick brown fox jumps over the lazy dog"
    val words = text.split(" ")

    // ============================================================
    // 5.1 MAP - TRANSFORM EACH ELEMENT
    // ============================================================
    println("━━━ 5.1 MAP ━━━\n")

    println("  Original words: $words")
    println("  Map to uppercase: ${words.map { it.uppercase() }}")
    println("  Map to length: ${words.map { it.length }}")
    println("  Map to first character: ${words.map { it.first() }}")
    println("  Map to " + "{word -> word.length}: ${words.map { word -> word.length }}")

    // ============================================================
    // 5.2 mapNotNull - MAP AND FILTER NULLS
    // ============================================================
    println("\n━━━ 5.2 mapNotNull ━━━\n")

    val mixed = listOf("123", "abc", "456", "def", "789")
    println("  Mixed: $mixed")
    println("  mapNotNull { it.toIntOrNull() }: ${mixed.mapNotNull { it.toIntOrNull() }}")
    println("  map { it.toIntOrNull() }: ${mixed.map { it.toIntOrNull() }}")

    // ============================================================
    // 5.3 FILTER - KEEP ONLY MATCHING ELEMENTS
    // ============================================================
    println("\n━━━ 5.3 FILTER ━━━\n")

    println("  Original words: $words")
    println("  Filter length > 3: ${words.filter { it.length > 3 }}")
    println("  Filter starts with 't': ${words.filter { it.startsWith("t") }}")
    println("  Filter contains 'o': ${words.filter { it.contains('o') }}")
    println("  Filter not length 3: ${words.filterNot { it.length == 3 }}")

    // ============================================================
    // 5.4 groupBy - GROUP ELEMENTS BY KEY
    // ============================================================
    println("\n━━━ 5.4 groupBy ━━━\n")

    println("  Original words: $words")
    val byLength = words.groupBy { it.length }
    println("  Group by length: $byLength")
    byLength.forEach { (length, wordList) ->
        println("    $length characters: $wordList")
    }

    val byFirstLetter = words.groupBy { it.first() }
    println("  Group by first letter:")
    byFirstLetter.forEach { (letter, wordList) ->
        println("    '$letter': $wordList")
    }

    // ============================================================
    // 5.5 DISTINCT - REMOVE DUPLICATES
    // ============================================================
    println("\n━━━ 5.5 DISTINCT ━━━\n")

    val duplicates = listOf("apple", "banana", "apple", "orange", "banana", "grape")
    println("  With duplicates: $duplicates")
    println("  distinct(): ${duplicates.distinct()}")
    println("  distinctBy { it.length }: ${duplicates.distinctBy { it.length }}")
    println("  distinctBy { it.first() }: ${duplicates.distinctBy { it.first() }}")

    // ============================================================
    // 5.6 SORTING
    // ============================================================
    println("\n━━━ 5.6 SORTING ━━━\n")

    val unsorted = listOf("zebra", "apple", "banana", "grape", "kiwi")
    println("  Unsorted: $unsorted")
    println("  sorted(): ${unsorted.sorted()}")
    println("  sortedDescending(): ${unsorted.sortedDescending()}")
    println("  sortedBy { it.length }: ${unsorted.sortedBy { it.length }}")
    println("  sortedByDescending { it.length }: ${unsorted.sortedByDescending { it.length }}")

    // ============================================================
    // 5.7 COMPLEX TRANSFORMATIONS
    // ============================================================
    println("\n━━━ 5.7 COMPLEX TRANSFORMATIONS ━━━\n")

    val sentence = "The quick brown fox jumps over the lazy dog"
    println("  Original: \"$sentence\"")

    // Chain operations
    val result = sentence
        .split(" ")
        .filter { it.length > 3 }
        .map { it.uppercase() }
        .sorted()
        .joinToString(", ")

    println("  Chain: $result")

    // ============================================================
    // 5.8 PRACTICE: TEXT ANALYZER
    // ============================================================
    println("\n━━━ 5.8 PRACTICE: TEXT ANALYZER ━━━\n")

    analyzeTextAdvanced("The quick brown fox jumps over the lazy dog")
    analyzeTextAdvanced("Kotlin is fun and Kotlin is powerful and Kotlin is modern")
}

fun analyzeTextAdvanced(text: String) {
    val words = text.split(Regex("[^A-Za-z]+"))
        .filter { it.isNotEmpty() }

    println("  📊 Advanced Analysis: \"$text\"")
    println("    Total words: ${words.size}")
    println("    Unique words: ${words.distinct().size}")
    println("    Word frequencies:")
    val frequencies = words.groupingBy { it.lowercase() }.eachCount()
    frequencies.forEach { (word, count) ->
        println("      '$word': $count")
    }
    println("    Words by length:")
    words.groupBy { it.length }
        .forEach { (length, wordList) ->
            println("      $length chars: ${wordList.distinct().joinToString()}")
        }
    println()
}