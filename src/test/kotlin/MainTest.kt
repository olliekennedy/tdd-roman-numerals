import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream
import kotlin.test.Test
import kotlin.test.assertEquals

class MainTest {
    @ParameterizedTest
    @MethodSource("provideNumberNumeralPairs")
    fun `return the correct roman numeral for a given number`(number: Int, numeral: String) {
        val actualOutput: String? = main(number)

        assertEquals(numeral, actualOutput)
    }

    @Test
    fun `handle bad input`() {
        val expectedOutput = null
        val actualOutput = main(-1)

        assertEquals(expectedOutput, actualOutput)
    }

    companion object {
        @JvmStatic
        fun provideNumberNumeralPairs(): Stream<Arguments> {
            return Stream.of(
                Arguments.of(0, ""),
                Arguments.of(1, "I"),
                Arguments.of(2, "II"),
                Arguments.of(3, "III"),
                Arguments.of(4, "IV"),
                Arguments.of(5, "V"),
                Arguments.of(6, "VI"),
                Arguments.of(7, "VII"),
                Arguments.of(8, "VIII"),
                Arguments.of(9, "IX"),
                Arguments.of(10, "X"),
                Arguments.of(11, "XI"),
                Arguments.of(14, "XIV"),
                Arguments.of(17, "XVII"),
                Arguments.of(19, "XIX"),
                Arguments.of(24, "XXIV"),
                Arguments.of(27, "XXVII"),
                Arguments.of(29, "XXIX"),
                Arguments.of(30, "XXX"),
                Arguments.of(42, "XLII"),
                Arguments.of(53, "LIII"),
                Arguments.of(59, "LIX"),
                Arguments.of(67, "LXVII"),
                Arguments.of(74, "LXXIV"),
                Arguments.of(77, "LXXVII"),
                Arguments.of(86, "LXXXVI"),
                Arguments.of(91, "XCI"),
                Arguments.of(98, "XCVIII"),
                Arguments.of(105, "CV"),
                Arguments.of(214, "CCXIV"),
                Arguments.of(326, "CCCXXVI"),
                Arguments.of(348, "CCCXLVIII"),
                Arguments.of(431, "CDXXXI"),
                Arguments.of(549, "DXLIX"),
                Arguments.of(555, "DLV"),
                Arguments.of(566, "DLXVI"),
                Arguments.of(610, "DCX"),
                Arguments.of(725, "DCCXXV"),
                Arguments.of(789, "DCCLXXXIX"),
                Arguments.of(846, "DCCCXLVI"),
                Arguments.of(888, "DCCCLXXXVIII"),
                Arguments.of(917, "CMXVII"),
                Arguments.of(999, "CMXCIX"),
            )
        }
    }
}
