package lotto

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class LottoGameTest {
    @Test
    fun `should correctly count winning tickets`() {
        val winningNumbers = Lotto(LottoNumbers(setOf(1, 2, 3, 4, 5, 6)))
        val bonusNumber = BonusNumber.of(7, winningNumbers.numbers.numbers)
        val tickets =
            listOf(
                Lotto(LottoNumbers(setOf(1, 2, 3, 4, 5, 6))),
                Lotto(LottoNumbers(setOf(1, 2, 3, 4, 5, 7))),
                Lotto(LottoNumbers(setOf(1, 2, 3, 4, 5, 45))),
                Lotto(LottoNumbers(setOf(1, 2, 3, 4, 44, 45))),
                Lotto(LottoNumbers(setOf(1, 2, 3, 43, 44, 45))),
                Lotto(LottoNumbers(setOf(10, 11, 12, 13, 14, 15))),
            )
        val game = LottoGame(tickets, winningNumbers, bonusNumber)
        game.play()
        val result = game.results
        assertEquals(1, result.getValue(Rank.FIRST))
        assertEquals(1, result.getValue(Rank.SECOND))
        assertEquals(1, result.getValue(Rank.THIRD))
        assertEquals(1, result.getValue(Rank.FOURTH))
        assertEquals(1, result.getValue(Rank.FIFTH))
        assertEquals(1, result.getValue(Rank.NONE))
    }
}
