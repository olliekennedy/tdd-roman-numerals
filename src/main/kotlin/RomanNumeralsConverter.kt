private const val MIN_NUMBER = 0
private const val MAX_NUMBER = 3999
private val VALID_NUMERALS = listOf('I', 'V', 'X')

fun romanNumeralsFromNumber(number: Int): String? {
    if (number.isOutOfRange()) return null

    return listOf(1000, 100, 10, 1)
        .map { digit -> digit.findHowManyIn(number).toNumeralsConsidering(digit) }
        .joinToString("")
}

fun numberFromRomanNumerals(numeral: String): Int? {
    if (numeral.any { it !in VALID_NUMERALS }) return null

    return numeral.toNumberConsidering(1)
}

private fun Int.isOutOfRange() = this < MIN_NUMBER || this > MAX_NUMBER

private fun Int.findHowManyIn(number: Int): Int = number.rem(this * 10).div(this)

private fun Int.toNumeralsConsidering(digit: Int): String? {
    val charMapping = digitToNumeralsMapping[digit]!!

    return numeralsMappingCalculatedUsing(charMapping)[this]
}

private fun String.toNumberConsidering(digit: Int): Int? {
    val charMapping = digitToNumeralsMapping[digit]!!

    val numberMapping = numberMappingCalculatedUsing(charMapping)

    return numberMapping[this]
}

private fun numberMappingCalculatedUsing(charMapping: Map<Int, String>): Map<String, Int> {
    return numeralsMappingCalculatedUsing(charMapping).map { (k, v) -> v to k }.toMap()
}

private fun numeralsMappingCalculatedUsing(charMapping: Map<Int, String>) = mapOf(
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
    1 to mapOf(1 to "I", 5 to "V", 10 to "X"),
    10 to mapOf(1 to "X", 5 to "L", 10 to "C"),
    100 to mapOf(1 to "C", 5 to "D", 10 to "M"),
    1000 to mapOf(1 to "M"),
)
