package behavioural.observer.novice

fun main() {
    val stockPriceManager = StockPriceManager()

    stockPriceManager.setPrice(100.0)
    stockPriceManager.setPrice(105.5)
}
