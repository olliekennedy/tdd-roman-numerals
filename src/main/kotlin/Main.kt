private const val MIN_NUMBER = 0
private const val MAX_NUMBER = 3999

fun main(number: Int): String? {
    if (number < MIN_NUMBER || number > MAX_NUMBER) return null

    return listOf(1000, 100, 10, 1)
        .map { digit -> digit.findHowManyIn(number).toNumeralsConsidering(digit) }
        .joinToString("")
}

private fun Int.findHowManyIn(number: Int): Int = number.rem(this * 10).div(this)

private fun Int.toNumeralsConsidering(digit: Int): String? {
    val charFor = charsFor[digit]!!
    val numeralsFor = mapOf(
        0 to "",
        1 to "${charFor[1]}",
        2 to "${charFor[1]}${charFor[1]}",
        3 to "${charFor[1]}${charFor[1]}${charFor[1]}",
        4 to "${charFor[1]}${charFor[5]}",
        5 to "${charFor[5]}",
        6 to "${charFor[5]}${charFor[1]}",
        7 to "${charFor[5]}${charFor[1]}${charFor[1]}",
        8 to "${charFor[5]}${charFor[1]}${charFor[1]}${charFor[1]}",
        9 to "${charFor[1]}${charFor[10]}",
    )

    return numeralsFor[this]
}

private val charsFor = mapOf(
    1 to mapOf(
        1 to "I",
        5 to "V",
        10 to "X",
    ),
    10 to mapOf(
        1 to "X",
        5 to "L",
        10 to "C",
    ),
    100 to mapOf(
        1 to "C",
        5 to "D",
        10 to "M",
    ),
    1000 to mapOf(
        1 to "M",
    ),
)
