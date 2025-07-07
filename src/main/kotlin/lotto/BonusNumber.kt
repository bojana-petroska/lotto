package lotto

@JvmInline
value class BonusNumber(val number: Int) {
    companion object {
        fun of(
            number: Int,
            primaryLottoNumbers: Set<Int>,
        ): BonusNumber {
            require(number in 1..45) {
                "Bonus number should be between 1 and 45"
            }
            require(!primaryLottoNumbers.contains(number)) {
                "Bonus number can't be in the lotto numbers."
            }
            return BonusNumber(number)
        }
    }
}
