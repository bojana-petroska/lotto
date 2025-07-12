package lotto

data class PurchaseResult(
    val money: Money,
    val tickets: List<Lotto>,
    val manualCount: Int,
)
