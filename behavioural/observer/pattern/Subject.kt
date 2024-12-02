package behavioural.observer.pattern

class Subject {

    private val observers = mutableListOf<Observer>()
    private var price = ""

    fun attach(observer: Observer) {
        observers.add(observer)
    }

    fun detach(observer: Observer) {
        observers.remove(observer)
    }

    fun setState(newPrice: String) {
        price = newPrice
        notifyObservers(price)
    }

    private fun notifyObservers(state: String) {
        observers.forEach { it ->
            it.update(state)
        }
    }

}