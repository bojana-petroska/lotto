package lotto

@JvmInline
value class LottoNumbers(val numbers: Set<Int>) {
    companion object {
        private const val NUMBERS_SIZE = 6

        fun of(numbers: List<Int>): LottoNumbers {
            require(numbers.size == NUMBERS_SIZE) {
                "Size of numbers should be equal $NUMBERS_SIZE"
            }
            require(numbers.toSet().size == NUMBERS_SIZE) {
                "lotto ticket numbers should be unique"
            }
            require(numbers.all { it in 1..45 }) {
                "lotto ticket each number should be between 1 and 45"
            }
            return LottoNumbers(numbers.toSet())
        }
    }
}
