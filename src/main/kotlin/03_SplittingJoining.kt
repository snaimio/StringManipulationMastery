package org.example

// Import shared utilities
import org.example.*  // This imports all extensions from _00_SharedUtils

fun main() {
    println("\n" + "═".repeat(60))
    println("  📚  LESSON 3: SPLITTING & JOINING")
    println("═".repeat(60) + "\n")

    val text = "The quick brown fox jumps over the lazy dog"

    // ============================================================
    // 3.1 SPLITTING BY DELIMITER
    // ============================================================
    println("━━━ 3.1 SPLITTING BY DELIMITER ━━━\n")

    // ✅ Use Regex split explicitly
    println("  Original: \"$text\"")
    println("  split(\" \"): ${text.split(" ")}")
    println("  split(Regex(\" \"), limit = 3): ${text.split(Regex(" "), limit = 3)}")

    // ============================================================
    // 3.2 SPLITTING WITH MULTIPLE DELIMITERS
    // ============================================================
    println("\n━━━ 3.2 SPLITTING WITH MULTIPLE DELIMITERS ━━━\n")

    val mixed = "apple,orange;banana:grape|melon"
    println("  Original: \"$mixed\"")
    println("  split(\",\", \";\", \":\", \"|\"): ${mixed.split(",", ";", ":", "|")}")
    println("  split(Regex(\"[,;:|]+\")): ${mixed.split(Regex("[,;:|]+"))}")

    // ============================================================
    // 3.3 FINDING SHORTEST WORD
    // ============================================================
    println("\n━━━ 3.3 FINDING SHORTEST WORD ━━━\n")

    val phrases = listOf(
        "kotlin makes coding fun and efficient",
        "The quick brown fox",
        "A B C D E F G",
        "Hello"
    )

    phrases.forEach { phrase ->
        val shortest = findShortestWord(phrase)
        println("  \"$phrase\"")
        println("    Shortest word: $shortest")
    }

    // ============================================================
    // 3.4 SPLITTING AND ANALYZING
    // ============================================================
    println("\n━━━ 3.4 SPLITTING AND ANALYZING ━━━\n")

    analyzeText("The brown fox jumps over the lazy dog")
    analyzeText("Kotlin, Java, Python, JavaScript, C++")
}

// ✅ Use this instead of the duplicate
fun findShortestWord(input: String): String? {
    val words = input
        .split(Regex("[^A-Za-z]+"))
        .filter { it.isNotEmpty() }

    if (words.isEmpty()) {
        return null
    }

    return words.minByOrNull { it.length }
}

fun analyzeText(text: String) {
    val words = text.split(Regex("[^A-Za-z]+"))
        .filter { it.isNotEmpty() }

    println("  📊 Analyzing: \"$text\"")
    println("    Total words: ${words.size}")
    println("    Shortest: ${words.minByOrNull { it.length }}")
    println("    Longest: ${words.maxByOrNull { it.length }}")
    println("    Average length: ${words.map { it.length }.average().format(2)}")
    println("    Words: ${words.joinToString()}")
    println()
}