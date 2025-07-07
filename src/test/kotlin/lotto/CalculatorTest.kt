package lotto

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class CalculatorTest {
    @Test
    fun `should divide integers and return a double`() {
        val a = 5000
        val b = 1000
        val result = 5.00
        assertThat(Calculator.division(a, b)).isEqualTo(result)
    }
}
