package behavioural.strategy.pattern

import behavioural.strategy.pattern.strategies.AlphabeticalSort
import behavioural.strategy.pattern.strategies.ReverseAlphabeticalSort

fun main() {

    val unsortedList = mutableListOf("Trump", "Biden", "Kamala", "Vance", "Vivek", "Tulsi")

    val sortingContext = SortingContext(AlphabeticalSort())
    println("Alphabetically sorted list : ${sortingContext.executeSort(unsortedList)}")

    sortingContext.setSortStrategy(ReverseAlphabeticalSort())
    println("Reverse alphabetically sorted list : ${sortingContext.executeSort(unsortedList)}")


}