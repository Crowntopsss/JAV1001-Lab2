// Temitope Adebiyi
// A00277004
// A simple command line application (ArrayTools.kt) that provides useful tools to developers
// with the following functions
// Encrypt a string
// Calculate array average
// Check array containment
// Reverse an array

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

