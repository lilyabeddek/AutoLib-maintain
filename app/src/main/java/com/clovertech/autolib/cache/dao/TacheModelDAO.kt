package com.clovertech.autolib.cache.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.clovertech.autolib.model.Tache
import com.clovertech.autolib.model.TacheModel

@Dao
interface TacheModelDAO {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addTaskModel(tacheModel: TacheModel)

    @Query("SELECT * FROM taskModel")
    fun getAllTasks(): LiveData<List<TacheModel>>
}