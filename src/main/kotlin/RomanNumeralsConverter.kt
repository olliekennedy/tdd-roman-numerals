private const val MIN_NUMBER = 0
private const val MAX_NUMBER = 3999
private val VALID_NUMERALS = listOf('I', 'V', 'X', 'L', 'C', 'D', 'M')

fun romanNumeralsFromNumber(number: Int): String? {
    if (number.isOutOfRange()) return null

    return listOf(1000, 100, 10, 1)
        .map { digit -> digit.findHowManyIn(number).toNumeralsConsidering(digit) }
        .joinToString("")
}

fun numberFromRomanNumerals(numeral: String): Int? {
    var numeralRemainder = numeral
    var onesNumerals = ""
    var tensNumerals = ""
    var hundredsNumerals = ""
    if (numeral.any { it !in VALID_NUMERALS }) return null

    for ((index, char) in numeralRemainder.withIndex()) {
        if (char in listOf(digitToNumeralsMapping[1]!![1], digitToNumeralsMapping[1]!![5])) {
            onesNumerals = numeralRemainder.substring(index, numeralRemainder.length)
            numeralRemainder = numeralRemainder.substring(0, index)
            break
        }
    }

    for ((index, char) in numeralRemainder.withIndex()) {
        if (char in listOf(digitToNumeralsMapping[10]!![1], digitToNumeralsMapping[10]!![5])) {
            tensNumerals = numeralRemainder.substring(index, numeralRemainder.length)
            numeralRemainder = numeralRemainder.substring(0, index)
            break
        }
    }

    for ((index, char) in numeralRemainder.withIndex()) {
        if (char in listOf(digitToNumeralsMapping[100]!![1], digitToNumeralsMapping[100]!![5])) {
            hundredsNumerals = numeralRemainder.substring(index, numeralRemainder.length)
            numeralRemainder = numeralRemainder.substring(0, index)
            break
        }
    }

    return onesNumerals.toNumberConsidering(1) + tensNumerals.toNumberConsidering(10) + hundredsNumerals.toNumberConsidering(100)
}

private fun Int.isOutOfRange() = this < MIN_NUMBER || this > MAX_NUMBER

private fun Int.findHowManyIn(number: Int): Int = number.rem(this * 10).div(this)

private fun Int.toNumeralsConsidering(digit: Int): String? {
    val charMapping = digitToNumeralsMapping[digit]!!

    return numeralsMappingCalculatedUsing(charMapping)[this]
}

private fun String.toNumberConsidering(digit: Int): Int {
    val charMapping = digitToNumeralsMapping[digit]!!

    val numberMapping = numberMappingCalculatedUsing(charMapping)

    return digit * (numberMapping[this] ?: 0)
}

private fun numberMappingCalculatedUsing(charMapping: Map<Int, Char>): Map<String, Int> {
    return numeralsMappingCalculatedUsing(charMapping).map { (k, v) -> v to k }.toMap()
}

private fun numeralsMappingCalculatedUsing(charMapping: Map<Int, Char>) = mapOf(
    0 to "",
    1 to "${charMapping[1]}",
    2 to "${charMapping[1]}${charMapping[1]}",
    3 to "${charMapping[1]}${charMapping[1]}${charMapping[1]}",
    4 to "${charMapping[1]}${charMapping[5]}",
    5 to "${charMapping[5]}",
    6 to "${charMapping[5]}${charMapping[1]}",
    7 to "${charMapping[5]}${charMapping[1]}${charMapping[1]}",
    8 to "${charMapping[5]}${charMapping[1]}${charMapping[1]}${charMapping[1]}",
    9 to "${charMapping[1]}${charMapping[10]}",
)

private val digitToNumeralsMapping = mapOf(
    1 to mapOf(1 to 'I', 5 to 'V', 10 to 'X'),
    10 to mapOf(1 to 'X', 5 to 'L', 10 to 'C'),
    100 to mapOf(1 to 'C', 5 to 'D', 10 to 'M'),
    1000 to mapOf(1 to 'M'),
)
