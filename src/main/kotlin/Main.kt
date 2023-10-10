fun main(number: Int): String? {
    if (number < 0 || number >= 4000) return null

    val hundreds = number.findHowMany(100)
    val tens = number.findHowMany(10)
    val ones = number.findHowMany(1)

    return hundredsNumeralFor[hundreds] + tensNumeralFor[tens] + onesNumeralFor[ones]
}

fun Int.findHowMany(divisor: Int): Int {
    return this.rem(divisor * 10).div(divisor)
}

val onesNumeralFor = mapOf(
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
    3 to "XXX",
    4 to "XL",
    5 to "L",
    6 to "LX",
    7 to "LXX",
    8 to "LXXX",
    9 to "XC",
)

val hundredsNumeralFor = mapOf(
    0 to "",
    1 to "C",
    2 to "CC",
    3 to "CCC",
    4 to "CD",
    5 to "D",
    6 to "DC",
    7 to "DCC",
    8 to "DCCC",
    9 to "CM",
)
