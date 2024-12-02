package behavioural.strategy

import behavioural.strategy.strategies.AlphabeticalSort
import behavioural.strategy.strategies.ReverseAlphabeticalSort

fun main() {

    val unsortedList = mutableListOf("Trump", "Biden", "Kamala", "Vance", "Vivek", "Tulsi")

    val sortingContext = SortingContext(AlphabeticalSort())
    println("Alphabetically sorted list : ${sortingContext.executeSort(unsortedList)}")

    sortingContext.setSortStrategy(ReverseAlphabeticalSort())
    println("Reverse alphabetically sorted list : ${sortingContext.executeSort(unsortedList)}")


}