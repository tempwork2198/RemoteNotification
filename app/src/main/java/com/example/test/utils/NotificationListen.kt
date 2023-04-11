package com.example.test.utils

import android.app.Notification
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.os.Build
import android.service.notification.NotificationListenerService
import android.service.notification.StatusBarNotification
import android.util.Log
import androidx.annotation.RequiresApi
import com.example.test.modals.NotificationData
import com.example.test.repository.NotificationSendAPI
import com.example.test.repository.RetrofitHelper
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class NotificationListen : NotificationListenerService() {

    private val TAG_LOCAL = "NOTIFICATION_SERVICE"
    private val temp : ArrayList<NotificationData> = arrayListOf()
    val quotesApi = RetrofitHelper.getInstance().create(NotificationSendAPI::class.java)


    override fun onCreate() {
        super.onCreate()
    }


    @RequiresApi(Build.VERSION_CODES.O)
    override fun onNotificationPosted(sbn: StatusBarNotification?, rankingMap: RankingMap?) {
        super.onNotificationPosted(sbn, rankingMap)

        if (sbn != null) {
            val bodyNotification = sbn.notification.tickerText
            val timeNotification = sbn.postTime
            val idNotification = sbn.id
            val keyNotification = sbn.key
            val packageNotification = sbn.packageName
            val titleNotification = sbn.notification.extras.getString(Notification.EXTRA_TITLE)
            val applicationNotification = sbn.notification.group


            temp.add(NotificationData(packageNotification,idNotification,keyNotification,timeNotification,titleNotification.toString(), bodyNotification.toString() ,applicationNotification))


            // launching a new coroutine
            GlobalScope.launch {
                val result = quotesApi.sendNotificationData(temp)
//            if (result != null)
//            // Checking the results
//                Log.d("ayush: ", )
            }


        };
    }



    class NLServiceReceiver : BroadcastReceiver(){
        override fun onReceive(context: Context?, intent: Intent?) {
            TODO("Not yet implemented")
        }

    }



}