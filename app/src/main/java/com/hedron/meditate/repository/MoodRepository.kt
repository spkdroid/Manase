package com.hedron.meditate.repository

import android.content.Context
import androidx.room.Room
import com.hedron.meditate.model.MoodModel
import com.hedron.meditate.repository.dao.MoodDao
import com.hedron.meditate.repository.database.MoodDatabase

class MoodRepository(private val applicationContext: Context) {
    private var database: MoodDatabase? = null

    val allLogs: List<MoodModel>
        get() = database!!.moodDaoAccess.fetchAll()

    init {
        initDB()
    }

    private fun initDB() {
        val DB_NAME = "MOODDATABASE"
        database = Room.databaseBuilder(applicationContext, MoodDatabase::class.java!!, DB_NAME)
            .fallbackToDestructiveMigration()
            .build()
    }

    fun addLog(logToBeAdded: MoodModel) {
        database!!.moodDaoAccess.insertSingleSong(logToBeAdded)
    }

    fun deleteLog(logToBeDeleted: MoodModel) {
        database!!.moodDaoAccess.deleteLog(logToBeDeleted)
    }

    fun clearTable() {
        database!!.moodDaoAccess.clearTable()
    }

    fun getLogById(Id: Int): MoodModel {
        return database!!.moodDaoAccess.fetchLogByID(Id)
    }
}