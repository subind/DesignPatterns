package behavioural.observer.novice

class StockPriceManager {
    private var stockPrice: Double = 0.0

    // Methods to set and get stock price
    fun setPrice(price: Double) {
        stockPrice = price
        updateComponents()
    }

    fun getPrice(): Double = stockPrice

    // Update all components directly
    private fun updateComponents() {
        Chart.update(stockPrice)
        List.update(stockPrice)
        NotificationSystem.notify(stockPrice)
    }
}
