package lotto

class BonusLotto(numbersList: List<Int>, val bonusNum: Int) : Lotto(numbersList) {
    init {
        require(numbers.all { it != bonusNum }) {
            "Bonus number should be unique"
        }
        require( bonusNum in (1 .. 45)) {
            "Bonus number should be in range from 1 to 45"
        }
    }
}