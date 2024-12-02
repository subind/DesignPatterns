package behavioural.strategy.novice

class SortingProcessor {

    fun processSorting(sortType: String, list: List<String>): List<String>? {
        when (sortType) {
            "AlphabeticalSort" -> {
                return list.sorted()
            }
            "ReverseAlphabeticalSort" -> {
                return list.sortedDescending()
            }
            else -> {
                println("Invalid payment type.")
                return null
            }
        }
    }
}