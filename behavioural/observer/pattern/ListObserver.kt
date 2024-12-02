package behavioural.observer.pattern

class ListObserver: Observer {

    override fun update(price: String) {
        println("List updated with price: $price")
    }
}