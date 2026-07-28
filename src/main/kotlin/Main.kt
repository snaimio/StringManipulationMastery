package org.example

/**
 * ============================================================
 * 🚀  STRING MANIPULATION MASTERY
 * 📚  Main Entry Point
 * ============================================================
 */

fun main() {
    println("\n" + "═".repeat(60))
    println("  🚀  STRING MANIPULATION MASTERY")
    println("  📚  Complete Learning Project")
    println("═".repeat(60) + "\n")

    // ============================================================
    // RUN SPECIFIC LESSONS (Uncomment to run)
    // ============================================================

    // Lesson 1: String Basics
    // _01_StringBasics.main()

    // Lesson 2: String Operations
    // _02_StringOperations.main()

    // Lesson 3: Splitting & Joining
    // _03_SplittingJoining.main()

    // Lesson 4: Searching & Checking
    // _04_SearchingChecking.main()

    // Lesson 5: Transformation
    // _05_Transformation.main()

    // Lesson 6: Regex
    // _06_Regex.main()

    // Lesson 7: String Templates
    // _07_StringTemplates.main()

    // Lesson 8: Extension Functions
    // _08_ExtensionFunctions.main()

    // Lesson 9: Advanced Examples
    // _09_AdvancedExamples.main()

    // Lesson 10: Practice Exercises
    // _10_PracticeExercises.main()

    // ============================================================
    // QUICK DEMO (Run this by default)
    // ============================================================

    println("━━━  QUICK DEMO ━━━\n")

    val text = "Kotlin makes coding fun and efficient"
    println("  Text: \"$text\"")
    println("  Shortest word: ${text.findShortestWord()}")
    println("  Longest word: ${text.longestWord()}")
    println("  Word count: ${text.wordCount()}")
    println("  Vowel count: ${text.countVowels()}")
    println("  Is palindrome? ${text.isPalindrome()}")
    println()

    val email = "john.doe@example.com"
    println("  Email: \"$email\"")
    println("  Is valid email? ${email.isValidEmail()}")
    println()

    val palindrome = "racecar"
    println("  \"$palindrome\" is palindrome? ${palindrome.isPalindrome()}")
    println()

    val anagram1 = "listen"
    val anagram2 = "silent"
    println("  \"$anagram1\" and \"$anagram2\" are anagrams? ${areAnagrams(anagram1, anagram2)}")
    println()

    // ============================================================
    // FOOTER
    // ============================================================

    println("═".repeat(60))
    println("  All lessons are available!")
    println("  💡  Uncomment any lesson in main() to run it.")
    println("═".repeat(60) + "\n")
}