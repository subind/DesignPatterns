package creational.factory.pattern

interface Notification {
    fun createNotification(context: AndroidContext): AndroidNotification
}

class AndroidNotification{}

class AndroidContext{}
