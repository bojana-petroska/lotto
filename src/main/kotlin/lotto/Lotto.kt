package lotto

class Lotto(val numbers: LottoNumbers) {
    fun matchCount(winningNums: LottoNumbers): Int {
        return numbers.numbers.count {
            it in winningNums.numbers
        }
    }

    fun containsBonusNum(bonusNum: BonusNumber): Boolean {
        return numbers.numbers.contains(bonusNum.number)
    }
}
