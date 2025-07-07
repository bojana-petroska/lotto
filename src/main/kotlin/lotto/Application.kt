package lotto

import view.InputView
import view.ResultView

fun main() {
    val amountInput = InputView.getAmountInput()
    val purchaseAmount = Money.of(amountInput)
    val lottoMachine = LottoMachine(purchaseAmount)
    val lottoTickets = lottoMachine.tickets

    ResultView.viewTicketsAmount(lottoTickets.size)
    ResultView.viewTickets(lottoTickets)

    val winningNumbersList = InputView.getWinningNumbers()
    val winningNumbers = LottoNumbers.of(winningNumbersList)

    val bonusNumberInput = InputView.getBonusNumber()
    val bonusNumber = BonusNumber.of(bonusNumberInput, winningNumbers.numbers)

    val winningLotto = Lotto(winningNumbers)

    val game = LottoGame(lottoTickets, winningLotto, bonusNumber)

    game.play()

    ResultView.viewWinning(game.results)
    ResultView.viewRate(game.winningAmount, purchaseAmount.amount)
}
