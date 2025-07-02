package lotto

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class BonusLottoTest {

    @Test
    fun `Bonus number should be unique`() {
        assertThrows<IllegalArgumentException> {
            BonusLotto(listOf(1, 2, 3, 4, 5, 6), 6)
        }
    }

    @Test
    fun `Bonus number should be in range from 1 to 45`() {
        assertThrows<java.lang.IllegalArgumentException> {
            BonusLotto(listOf(1, 2, 3, 4, 5, 6), 55)
        }
    }
}