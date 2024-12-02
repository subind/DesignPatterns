package behavioural.observer

class ConcreteObserver2: Observer {

    override fun update(state: String) {
        println("Notified in ${ConcreteObserver2::class.simpleName}, state: $state")
    }
}