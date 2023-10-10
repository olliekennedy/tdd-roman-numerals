import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class MainTest {
    @Test
    fun `return I for 1`() {
        val expectedOutput = "I"
        val actualOutput: String = main(1)

        assertEquals(expectedOutput, actualOutput)
    }

    @Test
    fun `return II for 2`() {
        val expectedOutput = "II"
        val actualOutput: String = main(2)

        assertEquals(expectedOutput, actualOutput)
    }
}
