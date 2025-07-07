package lotto

private const val TICKET_COST = 1000

class LottoMachine(val money: Money) {
    val tickets: List<Lotto>

    init {
        val ticketCount: Int = money.amount / TICKET_COST
        tickets = List(ticketCount) { Lotto(LottoNumbers.of(generateRandomNumber())) }
    }

    private fun generateRandomNumber() = (1..45).shuffled().take(6).sorted()
}
