package behavioural.strategy.pattern.strategies

interface SortingStrategy {

    fun sort(list: List<String>): List<String>
}