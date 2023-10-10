import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class MainTest {
    @Test
    fun `return I for 1`() {
        val expectedOutput = "I"
        val actualOutput: String = main(1)

        assertEquals(expectedOutput, actualOutput)
    }
}
