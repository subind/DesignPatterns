package behavioural.observer

class Subject {

    private val observers = mutableListOf<Observer>()
    private var state = ""

    fun attach(observer: Observer) {
        observers.add(observer)
    }

    fun detach(observer: Observer) {
        observers.remove(observer)
    }

    fun setState(newState: String) {
        state = newState
        notifyObservers(state)
    }

    private fun notifyObservers(state: String) {
        observers.forEach { it ->
            it.update(state)
        }
    }

}