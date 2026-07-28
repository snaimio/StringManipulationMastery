package org.example

fun main() {
    println("\n" + "═".repeat(60))
    println("  📚  LESSON 8: EXTENSION FUNCTIONS")
    println("═".repeat(60) + "\n")

    val text = "Hello Kotlin World"
    println("  \"$text\"")
    println("  wordCount(): ${text.wordCount()}")
    println("  shortestWord(): ${text.shortestWord()}")
    println("  longestWord(): ${text.longestWord()}")
    println("  averageWordLength(): ${text.averageWordLength().format(2)}")
    println("  isPalindrome(): ${text.isPalindrome()}")
    println()

    val phrase = "The quick brown fox"
    println("  \"$phrase\"")
    println("  containsLetter('x'): ${phrase.containsLetter('x')}")
    println("  containsLetter('z'): ${phrase.containsLetter('z')}")
    println("  removeVowels(): ${phrase.removeVowels()}")
    println("  removeConsonants(): ${phrase.removeConsonants()}")
    println("  reverseWords(): ${phrase.reverseWords()}")
    println()

    // Extension properties
    val sample = "Hello Kotlin"
    println("  \"$sample\"")
    println("  .vowelCount: ${sample.vowelCount}")
    println("  .consonantCount: ${sample.consonantCount}")
    println("  .isAllLetters: ${sample.isAllLetters}")
    println("  .isAllDigits: ${sample.isAllDigits}")
    println()

    // Validation extensions
    println("━━━ VALIDATION EXTENSIONS ━━━\n")

    val emails = listOf(
        "john@example.com",
        "invalid-email",
        "jane.doe@gmail.com",
        "not-an-email"
    )

    emails.forEach { email ->
        println("  \"$email\"")
        println("    isValidEmail(): ${email.isValidEmail()}")
    }
    println()

    // Your code as extensions
    println("━━━ YOUR CODE AS EXTENSIONS ━━━\n")

    val sentence = "kotlin makes coding fun and efficient"
    println("  \"$sentence\"")
    println("  .findShortestWord(): ${sentence.findShortestWord()}")
    println("  .doesFirstLetterExist(\"Paper\"): ${sentence.doesFirstLetterExist("Paper")}")
    println("  .doesFirstLetterExist(\"Efficient\"): ${sentence.doesFirstLetterExist("Efficient")}")
    println()

    // More practical extensions
    println("━━━ MORE PRACTICAL EXTENSIONS ━━━\n")

    val test = "Hello World 123"
    println("  \"$test\"")
    println("  .containsDigit(): ${test.containsDigit()}")
    println("  .containsUpperCase(): ${test.containsUpperCase()}")
    println("  .containsLowerCase(): ${test.containsLowerCase()}")
    println("  .toCamelCase(): ${test.toCamelCase()}")
    println("  .toSnakeCase(): ${test.toSnakeCase()}")
    println("  .removeSpaces(): ${test.removeSpaces()}")
}