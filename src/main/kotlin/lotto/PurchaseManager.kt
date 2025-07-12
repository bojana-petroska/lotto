package lotto

import view.InputView

object PurchaseManager {
    fun purchaseTickets(): PurchaseResult {
        val amountInput = InputView.getAmountInput()
        val purchaseAmount = Money.of(amountInput)

        val (manualCount, manualTickets) = manualTickets(purchaseAmount)

        val lottoMachine = LottoMachine(purchaseAmount, manualTickets)
        return PurchaseResult(purchaseAmount, lottoMachine.tickets, manualCount)
    }

    private fun manualTickets(purchaseAmount: Money): Pair<Int, List<LottoNumbers>> {
        val manuelTicketCount = InputView.getManualTicketCount()
        purchaseAmount.canPurchaseTickets(manuelTicketCount)

        InputView.getInputForNumber()
        val manuelTickets =
            List(manuelTicketCount) {
                InputView.getManualNumbers()
            }
        return manuelTicketCount to manuelTickets
    }
}
