fun main(number: Int): String? {
    if (number < 0) return null

    var output = ""

    output += tensNumeralFor[number / 10]
    output += numeralFor[number % 10]

    return output
}

val numeralFor = mapOf(
    0 to "",
    1 to "I",
    2 to "II",
    3 to "III",
    4 to "IV",
    5 to "V",
    6 to "VI",
    7 to "VII",
    8 to "VIII",
    9 to "IX",
)

val tensNumeralFor = mapOf(
    0 to "",
    1 to "X",
    2 to "XX",
)