package org.example

/**
 * ============================================================
 * LESSON 2: STRING OPERATIONS
 * ============================================================
 *
 * This file covers:
 * - Substring operations
 * - Replacement operations
 * - Removal operations
 * - Case conversion
 * - Trimming
 * - Padding
 * ============================================================
 */

fun main() {
    println("\n" + "═".repeat(60))
    println("  📚  LESSON 2: STRING OPERATIONS")
    println("═".repeat(60) + "\n")

    val text = "Hello Kotlin World!"

    // ============================================================
    // 2.1 SUBSTRING OPERATIONS
    // ============================================================
    println("━━━ 2.1 SUBSTRING OPERATIONS ━━━\n")

    println("  Original: \"$text\"")
    println("  substring(6): \"${text.substring(6)}\"")
    println("  substring(0, 5): \"${text.substring(0, 5)}\"")
    println("  substringBefore(' '): \"${text.substringBefore(' ')}\"")
    println("  substringAfter(' '): \"${text.substringAfter(' ')}\"")
    println("  substringBeforeLast(' '): \"${text.substringBeforeLast(' ')}\"")
    println("  substringAfterLast(' '): \"${text.substringAfterLast(' ')}\"")
    println("  substringBefore(\" Kotlin\"): \"${text.substringBefore(" Kotlin")}\"")
    println("  substringAfter(\"Hello \"): \"${text.substringAfter("Hello ")}\"")

    // ============================================================
    // 2.2 REPLACEMENT OPERATIONS
    // ============================================================
    println("\n━━━ 2.2 REPLACEMENT OPERATIONS ━━━\n")

    val sample = "Hello Hello World!"
    println("  Original: \"$sample\"")
    println("  replace(\"Hello\", \"Hi\"): \"${sample.replace("Hello", "Hi")}\"")
    println("  replaceFirst(\"Hello\", \"Hi\"): \"${sample.replaceFirst("Hello", "Hi")}\"")
    println("  replace(\"l\", \"L\"): \"${sample.replace("l", "L")}\"")
    println("  replace(\"l\", \"L\", ignoreCase = true): \"${sample.replace("l", "L", ignoreCase = true)}\"")
    println("  replace(Regex(\"[aeiou]\"), \"*\"): \"${sample.replace(Regex("[aeiou]"), "*")}\"")

    // ============================================================
    // 2.3 REMOVAL OPERATIONS
    // ============================================================
    println("\n━━━ 2.3 REMOVAL OPERATIONS ━━━\n")

    val original = "Hello Kotlin World"
    println("  Original: \"$original\"")
    println("  removePrefix(\"Hello \"): \"${original.removePrefix("Hello ")}\"")
    println("  removeSuffix(\" World\"): \"${original.removeSuffix(" World")}\"")
    println("  drop(6): \"${original.drop(6)}\"")
    println("  dropLast(6): \"${original.dropLast(6)}\"")
    println("  dropWhile { it != ' ' }: \"${original.dropWhile { it != ' ' }}\"")
    println("  dropLastWhile { it != ' ' }: \"${original.dropLastWhile { it != ' ' }}\"")
    println("  take(5): \"${original.take(5)}\"")
    println("  takeLast(5): \"${original.takeLast(5)}\"")
    println("  takeWhile { it != ' ' }: \"${original.takeWhile { it != ' ' }}\"")
    println("  takeLastWhile { it != ' ' }: \"${original.takeLastWhile { it != ' ' }}\"")

    // ============================================================
    // 2.4 CASE CONVERSION
    // ============================================================
    println("\n━━━ 2.4 CASE CONVERSION ━━━\n")

    val mixed = "Hello Kotlin 2026"
    println("  Original: \"$mixed\"")
    println("  uppercase(): \"${mixed.uppercase()}\"")
    println("  lowercase(): \"${mixed.lowercase()}\"")
    println("  capitalize(): \"${mixed.replaceFirstChar { it.uppercase() }}\"")
    println("  decapitalize(): \"${mixed.replaceFirstChar { it.lowercase() }}\"")

    // ============================================================
    // 2.5 TRIMMING
    // ============================================================
    println("\n━━━ 2.5 TRIMMING ━━━\n")

    val whitespace = "   Hello   World   "
    println("  Original: \"$whitespace\"")
    println("  trim(): \"${whitespace.trim()}\"")
    println("  trimStart(): \"${whitespace.trimStart()}\"")
    println("  trimEnd(): \"${whitespace.trimEnd()}\"")
    println("  trim { it == ' ' }: \"${whitespace.trim { it == ' ' }}\"")
    println("  trimStart { it == ' ' }: \"${whitespace.trimStart { it == ' ' }}\"")
    println("  trimEnd { it == ' ' }: \"${whitespace.trimEnd { it == ' ' }}\"")

    // ============================================================
    // 2.6 PADDING
    // ============================================================
    println("\n━━━ 2.6 PADDING ━━━\n")

    val word = "Hello"
    println("  Original: \"$word\"")
    println("  padStart(10, '*'): \"${word.padStart(10, '*')}\"")
    println("  padEnd(10, '*'): \"${word.padEnd(10, '*')}\"")
    println("  padStart(10): \"${word.padStart(10)}\"")
    println("  padEnd(10): \"${word.padEnd(10)}\"")

    // ============================================================
    // 2.7 REVERSAL AND REPETITION
    // ============================================================
    println("\n━━━ 2.7 REVERSAL AND REPETITION ━━━\n")

    val reverseMe = "Kotlin"
    println("  Original: \"$reverseMe\"")
    println("  reversed(): \"${reverseMe.reversed()}\"")
    println("  repeat(3): \"${reverseMe.repeat(3)}\"")

    // ============================================================
    // 2.8 PRACTICE: STRING TRANSFORMATIONS
    // ============================================================
    println("\n━━━ 2.8 PRACTICE: STRING TRANSFORMATIONS ━━━\n")

    transformString("hello world")
    transformString("KOTLIN IS AWESOME")
    transformString("   Hi   There   ")
}

fun transformString(text: String) {
    println("  Original: \"$text\"")
    println("    → Upper: \"${text.uppercase()}\"")
    println("    → Lower: \"${text.lowercase()}\"")
    println("    → Reversed: \"${text.reversed()}\"")
    println("    → First 5 chars: \"${text.take(5)}\"")
    println("    → Last 5 chars: \"${text.takeLast(5)}\"")
    println("    → Trimmed: \"${text.trim()}\"")
    println("    → Removed vowels: \"${text.replace(Regex("[aeiouAEIOU]"), "")}\"")
    println("    → Capitalized: \"${text.replaceFirstChar { it.uppercase() }}\"")
    println()
}