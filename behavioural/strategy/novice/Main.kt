package behavioural.strategy.novice

import behavioural.strategy.pattern.strategies.AlphabeticalSort
import behavioural.strategy.pattern.strategies.ReverseAlphabeticalSort

fun main() {

    val unsortedList = mutableListOf("Trump", "Biden", "Kamala", "Vance", "Vivek", "Tulsi")

    println("Reverse alphabetically sorted list : ${SortingProcessor().processSorting("ReverseAlphabeticalSort",unsortedList)}")


}