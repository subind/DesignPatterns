package creational.factory.pattern

import creational.factory.pattern.myNotificationManagers.NotificationManager

fun main() {

    val notificationManager = NotificationManager(context)

    // Sending a chat notification
    notificationManager.sendNotification("chat", "You have a new message!")

    // Sending a reminder notification
    notificationManager.sendNotification("reminder", "Don't forget to attend the meeting at 5 PM!")

    // Sending a promotion notification
    notificationManager.sendNotification("promotion", "50% off on your next purchase!")

}