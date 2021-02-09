package com.todo.app.main.data.remote.service

import android.text.TextUtils
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage
import com.todo.app.R
import com.todo.app.utils.helper.notification.NotificationUtils
import timber.log.Timber

/**
 * This is the notification service class of the project. This class contains all the
 * basic methods needed for the FCM push notifications.
 * @author Mohd. Asfaq-E-Azam Rifat *
 */
class NotificationService : FirebaseMessagingService() {

    /*
    FYI, The notification json should be like the following,

    {
        "to" : "YOUR_FCM_TOKEN_WILL_BE_HERE",
        "collapse_key" : "type_a",
        "notification" : {
            "body" : "Body of Your Notification",
            "title": "Title of Your Notification"
        },
        "data" : {
            "body" : "Body of Your Notification in Data",
            "title": "Title of Your Notification in Title",
            "key_1" : "Value for key_1",
            "key_2" : "Value for key_2"
        }
    }
    */

    companion object {
        const val TITLE = "title"
        const val BODY = "detail"
    }

    override fun onMessageReceived(message: RemoteMessage) {
        super.onMessageReceived(message)
        showNotification(message)
    }

    override fun onNewToken(p0: String) {
        super.onNewToken(p0)
        // TODO: send the new token to server
        Timber.d(p0)
    }

    private fun showNotification(message: RemoteMessage) {
        if (message.data.isEmpty()) {
            return
        }

        var title: String? = null
        var body: String? = null

        if (message.data.containsKey(TITLE)) {
            title = message.data[TITLE]
        }

        if (message.data.containsKey(BODY)) {
            body = message.data[BODY]
        }

        if (!TextUtils.isEmpty(title)
            && !TextUtils.isEmpty(body)
        ) {
            NotificationUtils.buildNotification(
                message.hashCode(),
                NotificationUtils.NotificationType.DEFAULT,
                R.drawable.ic_app_icon,
                title!!, body!!, body
            )
        }
    }
}