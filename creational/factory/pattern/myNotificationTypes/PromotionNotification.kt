package creational.factory.pattern.myNotificationTypes

import creational.factory.pattern.AndroidContext
import creational.factory.pattern.AndroidNotification
import creational.factory.pattern.Notification

class PromotionNotification(private val message: String) : Notification {
    override fun createNotification(context: AndroidContext): AndroidNotification {
        return NotificationCompat.Builder(context, "CHAT_CHANNEL")
            .setContentTitle("New Message")
            .setContentText(message)
            .setSmallIcon(R.drawable.ic_chat)
            .build()
    }
}