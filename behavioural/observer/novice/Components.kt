package behavioural.observer.novice

object Chart {
    fun update(price: Double) {
        println("Chart updated with price: $price")
    }
}

object List {
    fun update(price: Double) {
        println("List updated with price: $price")
    }
}

object NotificationSystem {
    fun notify(price: Double) {
        println("Notification sent with price: $price")
    }
}
