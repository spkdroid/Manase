package com.hedron.meditate.repository.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.hedron.meditate.model.MoodModel
import com.hedron.meditate.repository.dao.MoodDao


@Database(entities = arrayOf(MoodModel::class), version = 1)
abstract class MoodDatabase : RoomDatabase() {
    abstract val moodDaoAccess:MoodDao
}