package org.example

fun main() {
    println("\n" + "═".repeat(60))
    println("  📚  LESSON 9: ADVANCED EXAMPLES")
    println("═".repeat(60) + "\n")

    // ============================================================
    // 9.1 CHARACTER FREQUENCY
    // ============================================================
    println("━━━ 9.1 CHARACTER FREQUENCY ━━━\n")

    val text = "Hello World"
    println("  Text: \"$text\"")
    val freq = charFrequency(text)
    println("  Character frequencies:")
    freq.forEach { (char, count) ->
        println("    '$char': $count")
    }
    println()

    // ============================================================
    // 9.2 REMOVE DUPLICATE WORDS
    // ============================================================
    println("━━━ 9.2 REMOVE DUPLICATE WORDS ━━━\n")

    val duplicateText = "hello world hello kotlin world"
    println("  Original: \"$duplicateText\"")
    println("  Without duplicates: \"${removeDuplicateWords(duplicateText)}\"")
    println()

    // ============================================================
    // 9.3 ANAGRAM CHECKER
    // ============================================================
    println("━━━ 9.3 ANAGRAM CHECKER ━━━\n")

    val word1 = "listen"
    val word2 = "silent"
    val word3 = "hello"

    println("  Are \"$word1\" and \"$word2\" anagrams? ${areAnagrams(word1, word2)}")
    println("  Are \"$word1\" and \"$word3\" anagrams? ${areAnagrams(word1, word3)}")
    println()

    // ============================================================
    // 9.4 WORD FREQUENCY COUNTER
    // ============================================================
    println("━━━ 9.4 WORD FREQUENCY COUNTER ━━━\n")

    val story = "The cat and the dog. The cat is fast. The dog is loyal."
    println("  Story: \"$story\"")
    println("  Word frequencies:")
    countWordFrequency(story).forEach { (word, count) ->
        println("    '$word': $count")
    }
    println()

    // ============================================================
    // 9.5 EMAIL EXTRACTOR
    // ============================================================
    println("━━━ 9.5 EMAIL EXTRACTOR ━━━\n")

    val textWithEmails = """
        Contact us at: support@company.com or sales@company.com
        Also reach us at: info@company.com
    """.trimIndent()

    println("  Emails found: ${extractEmails(textWithEmails)}")
    println()

    // ============================================================
    // 9.6 PALINDROME CHECKER
    // ============================================================
    println("━━━ 9.6 PALINDROME CHECKER ━━━\n")

    val palindromes = listOf("racecar", "hello", "A man a plan a canal Panama")
    palindromes.forEach { str ->
        println("  \"$str\": ${str.isPalindrome()}")
    }
    println()

    // ============================================================
    // 9.7 STRING COMPRESSION
    // ============================================================
    println("━━━ 9.7 STRING COMPRESSION ━━━\n")

    val toCompress = "aaabbbccc"
    println("  Original: \"$toCompress\"")
    println("  Compressed: \"${compressString(toCompress)}\"")
    println()

    // ============================================================
    // 9.8 STRING DECOMPRESSION
    // ============================================================
    println("━━━ 9.8 STRING DECOMPRESSION ━━━\n")

    val compressed = "a3b3c3"
    println("  Compressed: \"$compressed\"")
    println("  Decompressed: \"${decompressString(compressed)}\"")
    println()

    // ============================================================
    // 9.9 FIND MOST COMMON WORD
    // ============================================================
    println("━━━ 9.9 FIND MOST COMMON WORD ━━━\n")

    val sampleText = "the dog and the cat and the bird"
    println("  Text: \"$sampleText\"")
    println("  Most common word: ${mostCommonWord(sampleText)}")
    println()
}

// ============================================================
// ADDITIONAL FUNCTIONS (Not in shared utils)
// ============================================================

fun charFrequency(text: String): Map<Char, Int> {
    return text.filter { it.isLetter() }
        .groupingBy { it.lowercaseChar() }
        .eachCount()
}

fun removeDuplicateWords(text: String): String {
    return text.split(Regex("[^A-Za-z]+"))
        .filter { it.isNotEmpty() }
        .distinct()
        .joinToString(" ")
}

fun countWordFrequency(text: String): Map<String, Int> {
    return text.split(Regex("[^A-Za-z]+"))
        .filter { it.isNotEmpty() }
        .groupingBy { it.lowercase() }
        .eachCount()
}

fun extractEmails(text: String): List<String> {
    val pattern = Regex("[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}")
    return pattern.findAll(text).map { it.value }.toList()
}

fun compressString(text: String): String {
    if (text.isEmpty()) return ""

    val result = StringBuilder()
    var count = 1
    var current = text[0]

    for (i in 1 until text.length) {
        if (text[i] == current) {
            count++
        } else {
            result.append(current)
            if (count > 1) result.append(count)
            current = text[i]
            count = 1
        }
    }
    result.append(current)
    if (count > 1) result.append(count)

    return result.toString()
}

fun decompressString(text: String): String {
    if (text.isEmpty()) return ""

    val result = StringBuilder()
    var i = 0

    while (i < text.length) {
        val char = text[i]
        i++
        var count = 0
        while (i < text.length && text[i].isDigit()) {
            count = count * 10 + (text[i] - '0')
            i++
        }
        if (count == 0) count = 1
        result.append(char.toString().repeat(count))
    }

    return result.toString()
}

fun mostCommonWord(text: String): String? {
    val words = text.split(Regex("[^A-Za-z]+")).filter { it.isNotEmpty() }
    if (words.isEmpty()) return null
    return words.groupingBy { it.lowercase() }.eachCount()
        .maxByOrNull { it.value }?.key
}