package lotto

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

private const val NUMBERS_SIZE = 6

class LottoTest {
    @Test
    fun `lotto ticket should have 6 numbers`() {
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(1, 2, 3, 4, 5, 6, 7))
        }
    }

    @Test
    fun `lotto ticket numbers size equals to 6`() {
        val lotto = Lotto(listOf(1, 2, 3, 4, 5, 6))
        assertTrue(lotto.getListOfNumbers().size == NUMBERS_SIZE)
    }

    @Test
    fun `lotto ticket numbers should be unique`() {
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(1, 2, 3, 4, 5, 5))
        }
    }

    @Test
    fun `lotto ticket numbers are unique`() {
        val lotto = Lotto(listOf(1, 2, 3, 4, 5, 6))
        assertTrue(lotto.getListOfNumbers().toSet().size == NUMBERS_SIZE)
    }

    @Test
    fun `lotto ticket each number should be between 1 and 45`() {
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(56, 1, 2, 3, 4, 5))
        }
    }

    @Test
    fun `lotto ticket should return match count`() {
        val lotto = Lotto(listOf(5, 6, 7, 8, 9, 10))
        val winningNums = listOf(1, 2, 3, 4, 5, 6)
        val matchCount = lotto.matchCount(winningNums)
        assertThat(matchCount).isEqualTo(2)
    }

    @Test
    fun `lotto ticket should check bonus number`() {
        val lotto = Lotto(listOf(5, 6, 7, 8, 9, 10))
        val bonusNum = 10
        val result = lotto.containsBonusNum(bonusNum)
        assertTrue(result)
    }
}