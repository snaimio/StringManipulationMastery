package org.example

/**
 * ============================================================
 * BONUS: ADDITIONAL STRING CONCEPTS
 * ============================================================
 *
 * This file covers extra string manipulation concepts:
 * - Chunking strings
 * - Windowed operations
 * - Zip operations
 * - Fold / Reduce with strings
 * - BuildString DSL
 * ============================================================
 */

fun main() {
    println("\n" + "═".repeat(60))
    println("  📚  BONUS: ADDITIONAL STRING CONCEPTS")
    println("═".repeat(60) + "\n")

    // ============================================================
    // 11.1 CHUNKING STRINGS
    // ============================================================
    println("━━━ 11.1 CHUNKING STRINGS ━━━\n")

    val text = "KotlinIsAwesome"
    println("  Text: \"$text\"")
    println("  chunked(3): ${text.chunked(3)}")
    println("  chunked(4): ${text.chunked(4)}")
    println()

    // ============================================================
    // 11.2 WINDOWED OPERATIONS
    // ============================================================
    println("━━━ 11.2 WINDOWED OPERATIONS ━━━\n")

    val word = "Kotlin"
    println("  Text: \"$word\"")
    println("  windowed(2): ${word.windowed(2)}")
    println("  windowed(3): ${word.windowed(3)}")
    println("  windowed(3, step=2): ${word.windowed(3, step = 2)}")
    println()

    // ============================================================
    // 11.3 ZIP OPERATIONS
    // ============================================================
    println("━━━ 11.3 ZIP OPERATIONS ━━━\n")

    val str1 = "Hello"
    val str2 = "World"
    println("  str1: \"$str1\"")
    println("  str2: \"$str2\"")
    println("  zip(): ${str1.zip(str2)}")
    println("  zip with transform: ${str1.zip(str2) { a, b -> "$a$b" }}")
    println()

    // ============================================================
    // 11.4 FOLD / REDUCE WITH STRINGS
    // ============================================================
    println("━━━ 11.4 FOLD / REDUCE WITH STRINGS ━━━\n")

    val names = listOf("Kotlin", "Java", "Python", "Swift")
    println("  Names: $names")
    println("  fold: ${names.fold("") { acc, s -> acc + s[0] }}")
    println("  reduce: ${names.reduce { acc, s -> "$acc, $s" }}")
    println()

    // ============================================================
    // 11.5 buildString DSL
    // ============================================================
    println("━━━ 11.5 buildString DSL ━━━\n")

    val buildResult = buildString {
        append("Hello")
        append(" ")
        append("Kotlin")
        append(" ")
        append(2026)
    }
    println("  buildString: \"$buildResult\"")
    println()

    // ============================================================
    // 11.6 STRING TO NUMBER CONVERSIONS
    // ============================================================
    println("━━━ 11.6 STRING TO NUMBER CONVERSIONS ━━━\n")

    val numbers = listOf("123", "456", "abc", "789")
    println("  Numbers: $numbers")
    println("  toIntOrNull: ${numbers.map { it.toIntOrNull() }}")
    println("  mapNotNull: ${numbers.mapNotNull { it.toIntOrNull() }}")
    println()

    // ============================================================
    // 11.7 COMPARE STRINGS (Levenshtein Distance)
    // ============================================================
    println("━━━ 11.7 COMPARE STRINGS ━━━\n")

    val s1 = "kitten"
    val s2 = "sitting"
    println("  \"$s1\" vs \"$s2\"")
    println("  Levenshtein distance: ${levenshteinDistance(s1, s2)}")
    println()

    // ============================================================
    // 11.8 STRING INTERLEAVING
    // ============================================================
    println("━━━ 11.8 STRING INTERLEAVING ━━━\n")

    val a = "abc"
    val b = "123"
    println("  \"$a\" + \"$b\" = ${interleave(a, b)}")
    println()
}

// ============================================================
// 11.7 LEVENSHTEIN DISTANCE
// ============================================================

fun levenshteinDistance(s1: String, s2: String): Int {
    val len1 = s1.length
    val len2 = s2.length

    val dp = Array(len1 + 1) { IntArray(len2 + 1) }

    for (i in 0..len1) dp[i][0] = i
    for (j in 0..len2) dp[0][j] = j

    for (i in 1..len1) {
        for (j in 1..len2) {
            val cost = if (s1[i - 1] == s2[j - 1]) 0 else 1
            dp[i][j] = minOf(
                dp[i - 1][j] + 1,
                dp[i][j - 1] + 1,
                dp[i - 1][j - 1] + cost
            )
        }
    }

    return dp[len1][len2]
}

// ============================================================
// 11.8 STRING INTERLEAVING
// ============================================================

fun interleave(str1: String, str2: String): String {
    val result = StringBuilder()
    val maxLen = maxOf(str1.length, str2.length)

    for (i in 0 until maxLen) {
        if (i < str1.length) result.append(str1[i])
        if (i < str2.length) result.append(str2[i])
    }

    return result.toString()
}