fun main(number: Int): String? {
    var output = ""

    if (number >= 10) output += "X"

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