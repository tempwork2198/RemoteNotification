package com.example.test.repository

import com.example.test.modals.NotificationData
import retrofit2.http.Body
import retrofit2.http.POST

interface NotificationSendAPI {

    @POST("/notification")
    suspend fun sendNotificationData(@Body data : ArrayList<NotificationData>)

}