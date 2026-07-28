@file:Suppress("Println")

package org.example

fun main() {
    println("\n" + "═".repeat(60))
    println("  📚  LESSON 1: STRING BASICS")
    println("═".repeat(60) + "\n")

    // ============================================================
    // 1.1 CREATING STRINGS
    // ============================================================
    println("━━━ 1.1 CREATING STRINGS ━━━\n")

    val str1 = "Hello Kotlin"
    println("  String literal: \"$str1\"")

    val charArray = charArrayOf('H', 'e', 'l', 'l', 'o')
    val str2 = String(charArray)
    println("  From char array: \"$str2\"")

    val str3 = StringBuilder().apply {
        append("Hello")
        append(" ")
        append("World")
    }.toString()
    println("  From StringBuilder: \"$str3\"")

    val empty = ""
    val blank = "   "
    println("  Empty string: \"$empty\" (length: 0)")
    println("  Blank string: \"$blank\" (length: ${blank.length})")

    val raw = """This is a raw string
        |It preserves formatting
        |and can contain special chars like \n without escaping""".trimMargin()
    println("  Raw string:\n$raw")

    // ============================================================
    // 1.2 STRING PROPERTIES
    // ============================================================
    println("\n━━━ 1.2 STRING PROPERTIES ━━━\n")

    val text = "Hello Kotlin World"
    println("  Text: \"$text\"")
    println("  Length: ${text.length}")
    println("  isEmpty: ${text.isEmpty()}")
    println("  isNotEmpty: ${text.isNotEmpty()}")
    println("  isBlank: ${text.isBlank()}")
    println("  isNotBlank: ${text.isNotBlank()}")
    println("  First character: '${text.first()}'")
    println("  Last character: '${text.last()}'")
    println("  Indices: ${text.indices}")
    println("  Last index: ${text.lastIndex}")

    // ============================================================
    // 1.3 ACCESSING CHARACTERS
    // ============================================================
    println("\n━━━ 1.3 ACCESSING CHARACTERS ━━━\n")

    val word = "Kotlin"
    println("  Word: \"$word\"")
    println("  word[0] = '${word[0]}'")
    println("  word[2] = '${word[2]}'")
    println("  word.last() = '${word.last()}'")
    println("  word.first() = '${word.first()}'")
    println("  word[3] = '${word[3]}'")

    val longWord = "KotlinProgramming"
    val safeChar = longWord[10]
    println("  Safe access (long word): '$safeChar'")

    val shortWord = "Kotlin"
    val safeChar2 = shortWord[0] // 'K'
    println("  Safe access (short word): '$safeChar2'")

    // ============================================================
    // 1.4 ITERATING THROUGH CHARACTERS
    // ============================================================
    println("\n━━━ 1.4 ITERATING THROUGH CHARACTERS ━━━\n")

    val name = "Kotlin"
    println("  Name: \"$name\"")

    print("  For loop: ")
    for (char in name) {
        print("$char ")
    }
    println()

    print("  ForEach: ")
    name.forEach { print("$it ") }
    println()

    print("  With index: ")
    name.forEachIndexed { index, char ->
        print("$char[$index] ")
    }
    println()

    print("  While loop: ")
    var i = 0
    while (i < name.length) {
        print("${name[i]} ")
        i++
    }
    println()

    // ============================================================
    // 1.5 CHARACTER OPERATIONS
    // ============================================================
    println("\n━━━ 1.5 CHARACTER OPERATIONS ━━━\n")

    val chars = listOf('A', 'a', '1', ' ', '\t', '!')
    println("  Character operations:")
    chars.forEach { c ->
        println("    '$c' - isLetter: ${c.isLetter()}, " +
                "isDigit: ${c.isDigit()}, " +
                "isLetterOrDigit: ${c.isLetterOrDigit()}, " +
                "isWhitespace: ${c.isWhitespace()}, " +
                "isUpperCase: ${c.isUpperCase()}, " +
                "isLowerCase: ${c.isLowerCase()}")
    }

    // ============================================================
    // 1.6 PRACTICE: WORD ANALYZER
    // ============================================================
    println("\n━━━ 1.6 PRACTICE: WORD ANALYZER ━━━\n")

    analyzeWord("Kotlin")
    analyzeWord("Hello World!")
    analyzeWord("12345")
    analyzeWord("   ")
}

fun analyzeWord(text: String) {
    println("  Analyzing: \"$text\"")
    println("    Length: ${text.length}")
    println("    Empty: ${text.isEmpty()}")
    println("    Blank: ${text.isBlank()}")
    println("    First char: '${text.firstOrNull()}'")
    println("    Last char: '${text.lastOrNull()}'")
    println("    Contains digits: ${text.any { it.isDigit() }}")
    println("    Contains letters: ${text.any { it.isLetter() }}")
    println("    All letters: ${text.all { it.isLetter() }}")
    println("    All digits: ${text.all { it.isDigit() }}")
    println()
}