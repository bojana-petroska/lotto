package lotto

import view.InputView
import view.ResultView

fun main() {
    val amountInput = InputView.getAmountInput()
    val purchaseAmount = Money.of(amountInput)

    val maxTickets = purchaseAmount.amount / TICKET_COST
    val manuelTicketCount = InputView.getManualTicketCount(maxTickets)

    val allManualTickets = mutableListOf<LottoNumbers>()
    InputView.getInputForNumber()
    repeat(manuelTicketCount) {
        val singleManualTicketNumbers = InputView.getManualNumbers()
        allManualTickets.add(singleManualTicketNumbers)
    }

    val lottoMachine = LottoMachine(purchaseAmount, allManualTickets)
    val lottoTickets = lottoMachine.tickets

    val automatedTicketCount = lottoTickets.size - manuelTicketCount
    ResultView.viewTicketsAmount(lottoTickets.size)
    ResultView.viewTickets(lottoTickets, manuelTicketCount, automatedTicketCount)

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
