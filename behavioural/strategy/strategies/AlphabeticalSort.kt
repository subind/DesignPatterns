package behavioural.strategy.strategies

class AlphabeticalSort: SortingStrategy {

    override fun sort(list: List<String>): List<String> {
        return list.sorted()
    }
}