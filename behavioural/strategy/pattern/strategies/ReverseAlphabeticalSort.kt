package behavioural.strategy.pattern.strategies

class ReverseAlphabeticalSort: SortingStrategy {

    override fun sort(list: List<String>): List<String> {
        return list.sortedDescending()
    }
}