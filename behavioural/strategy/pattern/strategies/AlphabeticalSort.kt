package behavioural.strategy.pattern.strategies

class AlphabeticalSort: SortingStrategy {

    override fun sort(list: List<String>): List<String> {
        return list.sorted()
    }
}