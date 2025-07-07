package lotto

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class MoneyTest {
    @Test
    fun `the amount should be greater or equal to 1,000 KRW`() {
        assertThrows<IllegalArgumentException> {
            Money.of(800)
        }
    }

    @Test
    fun `the amount should be divisible by 1000`() {
        assertThrows<IllegalArgumentException> {
            Money.of(1200)
        }
    }
}
