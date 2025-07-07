package lotto

@JvmInline
value class Money private constructor(val amount: Int) {
    companion object {
        fun of(amount: Int): Money {
            require(amount >= 1000) {
                "the amount should be minumum 1,000 KRW"
            }
            require(amount % 1000 == 0) {
                "the amount should be divisible by 1000"
            }
            return Money(amount)
        }
    }
}
