package behavioural.observer.pattern

fun main() {
    val subject = Subject()
    val observer1 = ChartObserver()
    val observer2 = ListObserver()

    subject.attach(observer1)
    subject.attach(observer2)
    subject.setState("Biden")
    subject.detach(observer2)
    subject.setState("Trump")
}