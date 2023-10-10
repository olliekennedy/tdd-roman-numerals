import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import org.junit.jupiter.params.provider.ValueSource
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

    @ParameterizedTest
    @ValueSource(ints = [-1, 4000])
    fun `handle bad input`(number: Int) {
        val expectedOutput = null
        val actualOutput = main(number)

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
                Arguments.of(1032, "MXXXII"),
                Arguments.of(1289, "MCCLXXXIX"),
                Arguments.of(1375, "MCCCLXXV"),
                Arguments.of(1597, "MDXCVII"),
                Arguments.of(1782, "MDCCLXXXII"),
                Arguments.of(2194, "MMCXCIV"),
                Arguments.of(2465, "MMCDLXV"),
                Arguments.of(2708, "MMDCCVIII"),
                Arguments.of(2999, "MMCMXCIX"),
                Arguments.of(3221, "MMMCCXXI"),
                Arguments.of(3366, "MMMCCCLXVI"),
                Arguments.of(3577, "MMMDLXXVII"),
                Arguments.of(3788, "MMMDCCLXXXVIII"),
                Arguments.of(3931, "MMMCMXXXI"),
                Arguments.of(3999, "MMMCMXCIX"),
            )
        }
    }
}
