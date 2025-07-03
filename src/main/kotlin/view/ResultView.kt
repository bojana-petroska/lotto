package view

import lotto.Lotto
import lotto.Rank

object ResultView {
    fun viewTicketsAmount(ticketsAmount: Int) {
        println("You have purchased $ticketsAmount tickets")
    }

    fun viewTickets(tickets: List<Lotto>) {
        tickets.forEach {
            println(it.getListOfNumbers().toString())
        }
    }

    fun viewWinning(resul: MutableMap<Rank, Int>) {
        println("Winning statistic")
        println("------------------")
        for (rank in Rank.entries.sortedBy { it.prizeAmount }) {
            if (rank == Rank.NONE) continue
            println("${rank.label} - ${resul[rank] ?: 0}  tickets")
        }
    }
}
