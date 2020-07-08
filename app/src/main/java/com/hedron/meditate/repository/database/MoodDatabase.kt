package com.hedron.meditate.repository.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.hedron.meditate.model.MoodModel
import com.hedron.meditate.repository.dao.MoodDao


@Database(entities = arrayOf(MoodModel::class), version = 1)
abstract class MoodDatabase : RoomDatabase() {
    abstract fun moodDaoAccess():MoodDao

    companion object {
        // Singleton prevents multiple instances of database opening at the
        // same time.
        @Volatile
        private var INSTANCE: MoodDatabase? = null

        fun getDatabase(context: Context): MoodDatabase {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    MoodDatabase::class.java,
                    "word_database"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }


}