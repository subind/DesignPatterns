package behavioural.observer

class ConcreteObserver1: Observer {

    override fun update(state: String) {
        println("Notified in ${ConcreteObserver1::class.simpleName}, state: $state")
    }
}