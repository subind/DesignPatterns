package creational.factory.pattern.myNotificationManagers

import creational.factory.pattern.myNotificationTypes.ChatNotification
import creational.factory.pattern.Notification
import creational.factory.pattern.myNotificationTypes.PromotionNotification
import creational.factory.pattern.myNotificationTypes.ReminderNotification

object NotificationFactory {
    fun createNotification(type: String, data: String): Notification {
        return when (type) {
            "chat" -> ChatNotification(data)
            "reminder" -> ReminderNotification(data)
            "promotion" -> PromotionNotification(data)
            else -> throw IllegalArgumentException("Unknown notification type: $type")
        }
    }
}
