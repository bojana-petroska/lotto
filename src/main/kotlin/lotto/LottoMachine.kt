package lotto

const val TICKET_COST = 1000

class LottoMachine(val money: Money, manuallyEnteredNumbers: List<LottoNumbers>) {
    val tickets: List<Lotto>

    init {
        val maxTickets = money.amount / TICKET_COST
        require(manuallyEnteredNumbers.size <= maxTickets) {
            "Cannot purchase more manual tickets than available money allows."
        }

        val manualLottoTickets = generateManualLottoTickets(manuallyEnteredNumbers)
        val remainingTicketCount = getAutomaticRemainingTicketsCount(manualLottoTickets)
        val automaticLottoTickets = automaticLottoTickets(remainingTicketCount)

        tickets = manualLottoTickets + automaticLottoTickets
    }

    private fun generateManualLottoTickets(numbers: List<LottoNumbers>): List<Lotto> {
        val manualLottoTickets =
            numbers.map { lottoNumbers ->
                Lotto(lottoNumbers)
            }
        return manualLottoTickets
    }

    private fun getAutomaticRemainingTicketsCount(manualLottoTickets: List<Lotto>): Int {
        val purchasedManualAmount = manualLottoTickets.size * TICKET_COST
        val remainingMoney = money.amount - purchasedManualAmount
        val remainingTicketCount: Int = remainingMoney / TICKET_COST
        return remainingTicketCount
    }

    private fun automaticLottoTickets(remainingTicketCount: Int): List<Lotto> {
        val automaticTickets = List(remainingTicketCount) { Lotto(LottoNumbers.of(generateRandomNumber())) }
        return automaticTickets
    }

    private fun generateRandomNumber() = (1..45).shuffled().take(6).sorted()
}
