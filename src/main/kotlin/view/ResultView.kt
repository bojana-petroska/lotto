package view

import lotto.Lotto

object ResultView {
    fun viewTicketsAmount(ticketsAmount: Int) {
        println("You have purchased $ticketsAmount tickets")
    }

    fun viewTickets(tickets: List<Lotto>) {
        tickets.forEach {
            println(it.getListOfNumbers().toString())
        }
    }
}