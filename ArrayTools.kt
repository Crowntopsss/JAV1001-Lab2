// Temitope Adebiyi
// A00277004
// A simple command line application (ArrayTools.kt) that provides useful tools to developers
// with the following functions
// Encrypt a string
// Calculate array average
// Check array containment
// Reverse an array

fun main() {
    val arrayTools = ArrayTools()

    println("Available functions:")
    println("1. Encrypt a string")
    println("2. Calculate array average")
    println("3. Check if an array contains a value")
    println("4. Reverse an array")
    println()

    print("Enter the action number to perform: ")
    val action = readLine()?.toIntOrNull()

    when (action) {
        1 -> {
            println("Enter the string to encrypt:")
            val message = readLine() ?: ""
            println("Enter the shift value:")
            val shift = readLine()?.toIntOrNull() ?: 0

            val encryptedMessage = arrayTools.encrypt(message, shift)
            println("Encrypted message: $encryptedMessage")
        }
        2 -> {
            val numbers = arrayTools.collectNumbersArray()
            val average = arrayTools.arrayAvg(numbers)
            println("Average: $average")
        }
        3 -> {
            val numbers = arrayTools.collectNumbersArray()
            print("Enter the value you want to search for")
            val action = readLine()?.toIntOrNull() ?: 0
            val searchValue = action
            val containsValue = arrayTools.arrayContains(numbers, searchValue)
            println("Contains value: $containsValue")
        }
        4 -> {
            val numbers = arrayTools.collectNumbersArray()
            val reversedArray = arrayTools.reverse(numbers)
            println("Reversed array: ${reversedArray.contentToString()}")
        }
        else -> {
            println("Invalid action number. Please try again.")
        }
    }
}


class ArrayTools {
    fun encrypt(message: String, shift: Int): String {
        // List to store the encrypted characters
        val encryptedChars = mutableListOf<Char>() 

        // Iterate over each character in the message
        for (char in message) { 
            // Encrypt the character and add the encrypted character to the list
            val encryptedChar = encryptChar(char, shift) 
            encryptedChars.add(encryptedChar)
        }

        return encryptedChars.joinToString("") 
    }

    fun encryptChar(char: Char, shift: Int): Char {
        val base = when {
            char.isLowerCase() -> 'a' 
            char.isUpperCase() -> 'A' 
            else -> return char
        }

        // Normalize the shift value to ensure it stays within the range of 26 letters
        // Calculate the encrypted character code
        // Convert the character code back to a character and return
        val normalizedShift = shift % 26 
        val encryptedCharCode = (char.toInt() - base.toInt() + normalizedShift) % 26 + base.toInt()
        return encryptedCharCode.toChar()
    }

    fun arrayAvg(numbers: Array<Int>): Double {
        // Calculate and return the average by dividing the sum by the size of the array
        var sum = 0 
        for (number in numbers) {
            sum += number
        }
        return sum.toDouble() / numbers.size 
    }

    fun arrayContains(array: Array<Int>, searchValue: Int): Boolean {
        // Iterate over each element in the array
        // Check if the element matches the search value
        // Return true if a match is found
        for (element in array) { 
            if (element == searchValue) { 
                return true 
            }
        }
        return false
    }

    fun reverse(array: Array<Int>): Array<Int> {
        // Create a new array with the same size as the original array
        val reversed = Array(array.size) { 0 } 
        var startIndex = 0
        var endIndex = array.size - 1

        while (startIndex <= endIndex) {
            // Store the value at the start index in a temporary variable
            val temp = array[startIndex]
            // Assign the value at the end index to the start index of the reversed array
            reversed[startIndex] = array[endIndex] 
            // Assign the value from the temporary variable to the end index of the reversed array
            reversed[endIndex] = temp 

            startIndex++ 
            endIndex--
        }

        return reversed
    }

    fun collectNumbersArray(): Array<Int> {
        println("Enter the numbers separated by spaces:")
        val input = readLine()
        return input?.split(" ")?.mapNotNull { it.toIntOrNull() }?.toTypedArray() ?: emptyArray()
    }
}

