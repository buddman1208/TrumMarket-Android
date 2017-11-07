package us.buddman.trumarket.firebase


import android.app.NotificationManager
import android.content.Context
import android.support.v4.app.NotificationCompat
import android.support.v4.app.TaskStackBuilder
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage
import us.buddman.trumarket.R

/**
 * Created by Junseok Oh on 2017-07-17.
 */

class MessagingService : FirebaseMessagingService() {

    override fun onMessageReceived(remoteMessage: RemoteMessage?) {
        val mBuilder = NotificationCompat.Builder(this)
                .setSmallIcon(R.mipmap.ic_launcher)
                .setContentTitle(remoteMessage!!.data["message"])
                .setContentText("Hello World!")
        val stackBuilder = TaskStackBuilder.create(this)
//            stackBuilder.addParentStack(ResultActivity::class.java)
//            stackBuilder.addNextIntent(resultIntent)
//        val resultPendingIntent = stackBuilder.getPendingIntent(
//                0,
//                PendingIntent.FLAG_UPDATE_CURRENT
//        )
//        mBuilder.setContentIntent(resultPendingIntent)
        val mNotificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        mNotificationManager.notify(6974, mBuilder.build())
    }
}
