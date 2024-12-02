package behavioural.observer.pattern

class ChartObserver: Observer {

    override fun update(price: String) {
        println("Chart updated with price: $price")
    }
}