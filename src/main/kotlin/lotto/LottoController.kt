package lotto

import view.InputView
import view.ResultView

object LottoController {
    fun start() {
        val purchaseResults = PurchaseManager.purchaseTickets()
        showPurchasedTickets(purchaseResults)

        val (winningNumbers, bonusNumber) = getWinningNumbersAndBonus()

        val game = LottoGame(purchaseResults.tickets, Lotto(winningNumbers), bonusNumber)

        showResults(game, purchaseResults.money.amount)
    }

    private fun showPurchasedTickets(purchaseResults: PurchaseResult) {
        val manualCount = purchaseResults.manualCount
        val autoCount = purchaseResults.tickets.size - manualCount

        ResultView.viewTicketsAmount(purchaseResults.tickets.size)
        ResultView.viewTickets(purchaseResults.tickets, manualCount, autoCount)
    }

    private fun getWinningNumbersAndBonus(): Pair<LottoNumbers, BonusNumber> {
        val winningNumbers = LottoNumbers.of(InputView.getWinningNumbers())
        val bonusNumber = BonusNumber.of(InputView.getBonusNumber(), winningNumbers.numbers)
        return winningNumbers to bonusNumber
    }

    private fun showResults(
        game: LottoGame,
        purchaseAmount: Int,
    ) {
        ResultView.viewWinning((game.results))
        ResultView.viewRate(game.winningAmount, purchaseAmount)
    }
}
