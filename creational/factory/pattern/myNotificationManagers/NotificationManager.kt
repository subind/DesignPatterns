package creational.factory.pattern.myNotificationManagers

class NotificationManager(private val context: Context) {
    fun sendNotification(type: String, data: String) {
        val notification = NotificationFactory.createNotification(type, data)
        val notificationManager =
            context.getSystemService(Context.NOTIFICATION_SERVICE) as android.app.NotificationManager

        notificationManager.notify(
            System.currentTimeMillis().toInt(),
            notification.createNotification(context)
        )
    }
}
