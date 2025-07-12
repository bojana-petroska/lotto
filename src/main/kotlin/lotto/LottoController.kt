package lotto

import view.InputView
import view.ResultView

object LottoController {
    fun start() {
        val purchaseResults = PurchaseManager.purchaseTickets()

        val manualCount = purchaseResults.manualCount
        val autoCount = purchaseResults.tickets.size - manualCount

        ResultView.viewTicketsAmount(purchaseResults.tickets.size)
        ResultView.viewTickets(purchaseResults.tickets, manualCount, autoCount)

        val winningNumbers = LottoNumbers.of(InputView.getWinningNumbers())
        val bonusNumber = BonusNumber.of(InputView.getBonusNumber(), winningNumbers.numbers)

        val game = LottoGame(purchaseResults.tickets, Lotto(winningNumbers), bonusNumber)

        ResultView.viewWinning((game.results))
        ResultView.viewRate(game.winningAmount, purchaseResults.money.amount)
    }
}
