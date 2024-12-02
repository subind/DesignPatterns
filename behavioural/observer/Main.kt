package behavioural.observer

fun main() {
    val subject = Subject()
    val observer1 = ConcreteObserver1()
    val observer2 = ConcreteObserver2()

    subject.attach(observer1)
    subject.attach(observer2)
    subject.setState("Biden")
    subject.detach(observer2)
    subject.setState("Trump")
}