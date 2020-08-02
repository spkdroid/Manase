package com.hedron.meditate.repository

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.room.Room
import com.hedron.meditate.model.MoodModel
import com.hedron.meditate.repository.dao.MoodDao
import com.hedron.meditate.repository.database.MoodDatabase

class MoodRepository(private val moodDao:MoodDao) {

    val allMoods:List<MoodModel> = moodDao.fetchAll().asReversed()

    fun getAll():List<MoodModel> {
        return moodDao.fetchAll()
    }

    fun insert(mood:MoodModel) {
        moodDao.insertSingleMood(mood)
    }

    fun getMoodByDate(date:String):List<MoodModel> {
        return moodDao.fetchMoodByDate(date)
    }


}