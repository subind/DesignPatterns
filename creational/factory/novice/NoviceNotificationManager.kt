package creational.factory.novice

/**
 * Problems with This Approach
 *
 * * Tightly Coupled Code:
 * The NotificationManager class is tightly coupled with the logic for creating each type of notification.
 * Adding a new notification type requires modifying the sendNotification method, violating the Open-Closed Principle (OCP).
 *
 * * Code Duplication:
 * Repeated use of NotificationCompat.Builder for different notification types makes the code harder to maintain.
 *
 * * Lack of Reusability:
 * The notification creation logic cannot be reused elsewhere in the app, leading to potential duplication if similar notifications need to be created in different places.
 *
 * * Scalability Issues:
 * Adding new notification types increases the complexity of the sendNotification method, making it harder to manage as the app grows.
 *
 * * Testing Challenges:
 * Testing individual notification creation logic becomes more challenging since it's embedded directly within the client code.
 *
 * * Breaks SRP
 */

class NoviceNotificationManager(private val context: Context) {

    fun sendNotification(type: String, data: String) {
        val notification = when (type) {
            "chat" -> NotificationCompat.Builder(context, "CHAT_CHANNEL")
                .setContentTitle("New Message")
                .setContentText(data)
                .setSmallIcon(R.drawable.ic_chat)
                .build()

            "reminder" -> NotificationCompat.Builder(context, "REMINDER_CHANNEL")
                .setContentTitle("Reminder")
                .setContentText(data)
                .setSmallIcon(R.drawable.ic_reminder)
                .build()

            "promotion" -> NotificationCompat.Builder(context, "PROMOTION_CHANNEL")
                .setContentTitle("Special Offer")
                .setContentText(data)
                .setSmallIcon(R.drawable.ic_promotion)
                .build()

            else -> throw IllegalArgumentException("Unknown notification type: $type")
        }

        val notificationManager =
            context.getSystemService(Context.NOTIFICATION_SERVICE) as android.app.NotificationManager

        notificationManager.notify(System.currentTimeMillis().toInt(), notification)
    }
}
