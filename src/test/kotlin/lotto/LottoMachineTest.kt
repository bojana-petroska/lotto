package lotto

import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

private const val TICKET_COST = 1000

class LottoMachineTest {
    @Test
    fun `machine should issue 2 tickets`() {
        val lottoMachine = LottoMachine(Money.of(2000))
        assertTrue(lottoMachine.tickets.size == 2000 / TICKET_COST)
    }
}
