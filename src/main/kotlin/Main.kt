fun main(number: Int): String? {
    val numberToNumeralMapping = mapOf(
        1 to "I",
        2 to "II",
        3 to "III",
        4 to "IV",
        5 to "V",
        6 to "VI",
        7 to "VII",
        8 to "VIII",
        9 to "IX",
        10 to "X",
        11 to "XI",
    )
    return numberToNumeralMapping[number]
}
