package com.hedron.meditate.repository

import android.content.Context
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import com.hedron.meditate.model.MoodModel
import com.hedron.meditate.repository.dao.MoodDao
import com.hedron.meditate.repository.database.MoodDatabase
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
class MoodRepositoryTest {

    lateinit var context: Context

    lateinit var moodRepository:MoodDao

    @Before
    fun setUp() {
        context =  InstrumentationRegistry.getInstrumentation().targetContext
        moodRepository = MoodDatabase.getDatabase(context).moodDaoAccess()
        moodRepository.clearTable()
    }

    @Test
    fun Insert_Test_Mood() {
        moodRepository.insertSingleMood(MoodModel(1,"1","1","1"))
        Assert.assertTrue(moodRepository.fetchAll().isNotEmpty())
    }

    @Test
    fun Get_Test_Mood() {
        moodRepository.insertSingleMood(MoodModel(1,"1","1","1"))
        val getMood = moodRepository.fetchMoodByDate("1")
        Assert.assertTrue(getMood.size == 1)
    }

}