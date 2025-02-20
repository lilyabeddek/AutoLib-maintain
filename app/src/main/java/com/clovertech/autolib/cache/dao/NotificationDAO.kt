package com.clovertech.autolib.cache.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.clovertech.autolib.ui.notifications.Notif

@Dao
interface NotificationDAO {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertNotification(notif: Notif)

    @Query("SELECT * FROM Notifications")
    fun getAllNotifications(): LiveData<List<Notif>>


}