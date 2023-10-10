fun main(number: Int): String? {
    val numberToNumeralMapping = mapOf(
        1 to "I",
        2 to "II",
        3 to "III",
        4 to "IV",
    )
    return numberToNumeralMapping[number]
}
