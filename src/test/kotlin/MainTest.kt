import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream
import kotlin.test.assertEquals

class MainTest {
    @ParameterizedTest
    @MethodSource("provideNumberNumeralPairs")
    fun `return the correct roman numeral for a given number`(number: Int, numeral: String) {
        val actualOutput: String? = main(number)

        assertEquals(numeral, actualOutput)
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
            )
        }
    }
}
