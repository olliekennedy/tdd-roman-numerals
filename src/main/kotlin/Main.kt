fun main(number: Int): String? {
    if (number < 0 || number >= 4000) return null

    val thousands = 1000.findHowManyIn(number)
    val hundreds = 100.findHowManyIn(number)
    val tens = 10.findHowManyIn(number)
    val ones = 1.findHowManyIn(number)

    return something(thousands, thousandsChars) + something(hundreds, hundredsChars) + something(tens, tensChars) + something(ones, onesChars)
}

fun Int.findHowManyIn(number: Int): Int {
    return number.rem(this * 10).div(this)
}

fun something(number: Int, construct: Map<String, String?>): String? {
    val numeralFor = mapOf(
        0 to "",
        1 to "${construct["one"]}",
        2 to "${construct["one"]}${construct["one"]}",
        3 to "${construct["one"]}${construct["one"]}${construct["one"]}",
        4 to "${construct["one"]}${construct["five"]}",
        5 to "${construct["five"]}",
        6 to "${construct["five"]}${construct["one"]}",
        7 to "${construct["five"]}${construct["one"]}${construct["one"]}",
        8 to "${construct["five"]}${construct["one"]}${construct["one"]}${construct["one"]}",
        9 to "${construct["one"]}${construct["ten"]}",
    )

    return numeralFor[number]
}

val thousandsChars = mapOf(
    "one" to "M",
)
val hundredsChars = mapOf(
    "one" to "C",
    "five" to "D",
    "ten" to thousandsChars["one"],
)
val tensChars = mapOf(
    "one" to "X",
    "five" to "L",
    "ten" to hundredsChars["one"],
)
val onesChars = mapOf(
    "one" to "I",
    "five" to "V",
    "ten" to tensChars["one"],
)
