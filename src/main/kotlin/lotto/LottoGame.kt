package lotto

class LottoGame(val playersTickets: List<Lotto>, val winningNumbers: Lotto, val bonusNumber: BonusNumber) {
    val results: MutableMap<Rank, Int> = mutableMapOf()
    var winningAmount = 0

    fun play() {
        for (ticket in playersTickets) {
            val matchCount = ticket.matchCount(winningNumbers.numbers)
            val hasBonusNum = ticket.containsBonusNum(bonusNumber)
            val rank = Rank.getRank(matchCount, hasBonusNum)
            results[rank] = results.getOrDefault(rank, 0) + 1
            winningAmount += rank.prizeAmount
        }
    }
}
