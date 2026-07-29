@file:Suppress("Println")

package org.example

/**
 * ============================================================
 * LESSON 12: CAESAR CIPHER
 * ============================================================
 *
 * 📚 WHAT IS A CAESAR CIPHER?
 *    A simple substitution cipher that shifts each letter by
 *    a fixed number of positions in the alphabet.
 *
 * 📖 HISTORY:
 *    Named after Julius Caesar, who used it to send military
 *    messages in ancient Rome.
 *
 * 🔐 HOW IT WORKS:
 *    Each letter is replaced by a letter some fixed number of
 *    positions down the alphabet.
 *
 *    Example with key = 2:
 *      'A' → 'C'
 *      'B' → 'D'
 *      'Z' → 'B' (wraps around)
 *      'Hello' → 'Jgnnq'
 *
 * ⚠️ SECURITY WARNING:
 *    This is for EDUCATIONAL purposes only!
 *    NOT secure for real encryption!
 * ============================================================
 */

fun main() {
    println("\n" + "═".repeat(60))
    println("  📚  LESSON 12: CAESAR CIPHER")
    println("═".repeat(60) + "\n")

    // ============================================================
    // 12.1 BASIC ENCRYPTION
    // ============================================================
    println("━━━ 12.1 BASIC ENCRYPTION ━━━\n")

    val text = "Hello World!"
    val key = 2

    val encrypted = encryptString(text, key)
    val decrypted = decryptString(encrypted, key)

    println("  Original:  $text")
    println("  Key:       $key")
    println("  Encrypted: $encrypted")
    println("  Decrypted: $decrypted")
    println()

    // ============================================================
    // 12.2 TEST WITH DIFFERENT KEYS
    // ============================================================
    println("━━━ 12.2 TEST WITH DIFFERENT KEYS ━━━\n")

    testCaesarCipher("Kotlin", 1)
    testCaesarCipher("Kotlin", 3)
    testCaesarCipher("Kotlin", 5)
    testCaesarCipher("Kotlin", 10)
    println()

    // ============================================================
    // 12.3 EDGE CASES
    // ============================================================
    println("━━━ 12.3 EDGE CASES ━━━\n")

    // Shift by 26 = same as original (full rotation)
    testCaesarCipher("Hello", 26)

    // Shift by 0 = same as original
    testCaesarCipher("Hello", 0)

    // Large shift (same as shift by 3)
    testCaesarCipher("Hello", 29)  // 29 % 26 = 3

    // Empty string
    val empty = encryptString("", 5)
    println("  Empty string: \"$empty\"")

    // String with special characters
    testCaesarCipher("Hello@World!123", 2)
    println()

    // ============================================================
    // 12.4 BRUTE FORCE ATTACK
    // ============================================================
    println("━━━ 12.4 BRUTE FORCE ATTACK ━━━\n")

    val secret = "Kotlin"
    val encryptedSecret = encryptString(secret, 3)
    println("  Encrypted secret: \"$encryptedSecret\"")
    println("  Brute forcing all 26 keys:\n")

    bruteForceCaesar(encryptedSecret)
    println()
}

// ============================================================
// ENCRYPTION FUNCTIONS
// ============================================================

/**
 * Encrypts a string using Caesar cipher.
 *
 * @param input The string to encrypt
 * @param move The number of positions to shift (positive = backward)
 * @return The encrypted string
 */
fun encryptString(input: String, move: Int): String {
    val shift = move % 26
    val result = StringBuilder()

    for (char in input) {
        when {
            char in 'a'..'z' -> {
                var shifted = char - shift
                if (shifted < 'a') shifted += 26
                result.append(shifted)
            }
            char in 'A'..'Z' -> {
                var shifted = char - shift
                if (shifted < 'A') shifted += 26
                result.append(shifted)
            }
            else -> result.append(char)
        }
    }

    return result.toString()
}

/**
 * Decrypts a string by shifting each letter forward.
 */
fun decryptString(input: String, move: Int): String {
    return encryptString(input, -move)
}

/**
 * Tests Caesar cipher with a given text and key.
 */
fun testCaesarCipher(text: String, key: Int) {
    val encrypted = encryptString(text, key)
    val decrypted = decryptString(encrypted, key)
    val status = if (decrypted == text) "✅" else "❌"
    println("  $status Key $key: '$text' → '$encrypted' → '$decrypted'")
}

/**
 * Brute forces all 26 possible keys to decrypt a Caesar cipher.
 */
fun bruteForceCaesar(encrypted: String) {
    for (key in 1..26) {
        val decrypted = decryptString(encrypted, key)
        println("    Key $key: $decrypted")
    }
}