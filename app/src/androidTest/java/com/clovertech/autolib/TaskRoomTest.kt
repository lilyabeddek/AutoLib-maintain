package com.clovertech.autolib

import androidx.room.Room
import androidx.test.filters.LargeTest
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import androidx.test.platform.app.InstrumentationRegistry
import com.clovertech.autolib.cache.db.AutolibDatabase
import com.clovertech.autolib.model.Tache
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import java.util.*

@RunWith(AndroidJUnit4ClassRunner::class)
@LargeTest
class TaskRoomTest {
    lateinit var mDataBase:AutolibDatabase
    @Before
    fun initDB() {
        mDataBase =
            Room.inMemoryDatabaseBuilder(InstrumentationRegistry. getInstrumentation().context,AutolibDatabase::class.java).build()
    }
    @Test
    fun testInsertAndGetUser() {
        var task: Tache =
            Tache(0, 0, "", "", 0, Date(), Date(),
                mutableListOf(), mutableListOf(), "")
        CoroutineScope(Dispatchers.IO).launch {
            mDataBase?.tacheDao().addTask(task)
            val list = mDataBase?.tacheDao().getAllTasks()
            Assert.assertEquals(task, list.value?.get(0))}

    }
    @After
    fun closeDb(){
        mDataBase?.close()
    }
}