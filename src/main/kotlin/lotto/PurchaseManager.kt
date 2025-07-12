package lotto

import view.InputView

object PurchaseManager {
    fun purchaseTickets(): PurchaseResult {
        val amountInput = InputView.getAmountInput()
        val purchaseAmount = Money.of(amountInput)

        val manuelTicketCount = InputView.getManualTicketCount(purchaseAmount.maxTickets(amountInput))
        purchaseAmount.canPurchaseTickets(manuelTicketCount)

        InputView.getInputForNumber()
        val manualTickets =
            List(manuelTicketCount) {
                InputView.getManualNumbers()
            }

        val lottoMachine = LottoMachine(purchaseAmount, manualTickets)
        return PurchaseResult(purchaseAmount, lottoMachine.tickets, manuelTicketCount)
    }
}
