package com.hedron.meditate.repository

import android.app.Application
import android.content.Context
import androidx.test.platform.app.InstrumentationRegistry
import com.hedron.meditate.model.MoodModel
import com.hedron.meditate.repository.dao.MoodDao
import com.hedron.meditate.repository.database.MoodDatabase
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock

class MoodRepositoryTest {

    lateinit var moodRepository: MoodDao

    @Mock
    lateinit var ctx:Context

    @Before
    fun Initialize() {
        val moodDao = MoodDatabase.getDatabase(ctx).moodDaoAccess()
        var moodRepository = moodDao
    }

    @Test
    fun Insert_Test_Mood() {
       moodRepository.insertSingleMood(MoodModel(1,"1","1","1"))
       Assert.assertTrue(moodRepository.fetchAll().isNotEmpty())
    }



}