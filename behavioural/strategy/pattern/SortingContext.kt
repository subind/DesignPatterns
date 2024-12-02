package behavioural.strategy.pattern

import behavioural.strategy.pattern.strategies.SortingStrategy

class SortingContext(strategy: SortingStrategy) {

    private var currentStrategyContext = strategy

    fun setSortStrategy(strategy: SortingStrategy) {
        currentStrategyContext = strategy
    }

    fun executeSort(list: List<String>): List<String> {
        return currentStrategyContext.sort(list)
    }
}