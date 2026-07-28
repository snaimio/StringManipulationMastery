package org.example

import org.example.*

fun main() {
    println("\n" + "═".repeat(60))
    println("  📚  LESSON 7: STRING TEMPLATES")
    println("═".repeat(60) + "\n")

    // ============================================================
    // 7.1 BASIC INTERPOLATION
    // ============================================================
    println("━━━ 7.1 BASIC INTERPOLATION ━━━\n")

    val name = "Kotlin"
    val version = 1.9
    val isAwesome = true

    println("  name = \"$name\"")
    println("  version = $version")
    println("  isAwesome = $isAwesome")
    println("  Hello $name!")  // Simple variable
    println("  Version $version")

    // ============================================================
    // 7.2 EXPRESSION INTERPOLATION
    // ============================================================
    println("\n━━━ 7.2 EXPRESSION INTERPOLATION ━━━\n")

    val str = "Hello"
    println("  str = \"$str\"")
    println("  ${str.uppercase()}")  // Expression
    println("  ${str.reversed()}")   // Expression
    println("  ${str.length}")       // Property
    println("  ${if (isAwesome) "Awesome!" else "Boo!"}")  // If expression
    println("  ${listOf(1, 2, 3)}")  // Any expression
    println("  ${1 + 2 + 3}")        // Arithmetic

    // ============================================================
    // 7.3 MULTI-LINE STRINGS
    // ============================================================
    println("\n━━━ 7.3 MULTI-LINE STRINGS ━━━\n")

    // Method 1: Using trimIndent()
    val multiline1 = """
        This is a
        multi-line string
        with three lines
    """.trimIndent()
    println("  $multiline1")

    // Method 2: Using trimMargin() with default |
    val multiline2 = """
        |Line 1
        |Line 2
        |Line 3
    """.trimMargin()
    println("  $multiline2")

    // Method 3: Using trimMargin() with custom character
    val multiline3 = """
        >Line 1
        >Line 2
        >Line 3
    """.trimMargin(">")
    println("  $multiline3")

    // ============================================================
    // 7.4 RAW STRINGS
    // ============================================================
    println("\n━━━ 7.4 RAW STRINGS ━━━\n")

    // Normal string with escaping
    val normal = "Hello\nWorld\tKotlin"
    println("  Normal string: $normal")

    // Raw string (no escaping)
    val raw = """Hello\nWorld\tKotlin"""
    println("  Raw string: $raw")

    // File path without escaping
    val path = """C:\Users\MyFolder\file.txt"""
    println("  File path: $path")

    // ============================================================
    // 7.5 STRING BUILDERS
    // ============================================================
    println("\n━━━ 7.5 STRING BUILDERS ━━━\n")

    // Method 1: StringBuilder
    val sb = StringBuilder()
    sb.append("Hello")
    sb.append(" ")
    sb.append("World")
    println("  StringBuilder: ${sb.toString()}")

    // Method 2: buildString
    val result = buildString {
        append("Hello")
        append(" ")
        append("Kotlin")
    }
    println("  buildString: $result")

    // Method 3: append with loop
    val numbers = buildString {
        for (i in 1..5) {
            append(i)
            if (i < 5) append(", ")
        }
    }
    println("  Numbers: $numbers")

    // ============================================================
    // 7.6 PRACTICE: TEMPLATE EXAMPLES (Option 2 - Shows Both Cases)
    // ============================================================
    println("\n━━━ 7.6 PRACTICE: TEMPLATE EXAMPLES ━━━\n")

    val firstName = "John"
    val lastName = "Doe"
    val age = 30
    val city = "New York"
    val salary1 = 50000   // Low salary (no bonus)
    val salary2 = 120000  // High salary (has bonus)
    val bonusThreshold = 100000

    // Create a user profile showing both cases
    val profile = """
        =================================
        USER PROFILE
        =================================
        Name: $firstName $lastName
        Age: $age
        City: $city
        
        Salary Examples:
        • Salary 1 ($${salary1}): ${if (salary1 > bonusThreshold) "Has bonus ✅" else "No bonus ❌"}
        • Salary 2 ($${salary2}): ${if (salary2 > bonusThreshold) "Has bonus ✅" else "No bonus ❌"}
        
        Bonus Threshold: $${bonusThreshold}
        Initials: ${firstName.take(1)}${lastName.take(1)}
    """.trimIndent()

    println(profile)

    // ============================================================
    // 7.7 MORE EXAMPLES
    // ============================================================
    println("\n━━━ 7.7 MORE EXAMPLES ━━━\n")

    val items = listOf("Apple", "Banana", "Orange")

    // Format a list
    val listString = buildString {
        append("Shopping List:\n")
        items.forEachIndexed { index, item ->
            append("  ${index + 1}. $item\n")
        }
    }
    println(listString)

    // HTML template
    val html = """
        <html>
            <head>
                <title>${"Welcome to Kotlin"}</title>
            </head>
            <body>
                <h1>${"Hello $firstName $lastName"}</h1>
                <p>Age: ${age}</p>
                <p>City: ${city}</p>
            </body>
        </html>
    """.trimIndent()

    println("  HTML: $html")
}