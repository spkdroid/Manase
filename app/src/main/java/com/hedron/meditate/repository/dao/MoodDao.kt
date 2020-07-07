package com.hedron.meditate.repository.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.hedron.meditate.model.MoodModel

@Dao
interface MoodDao {

    @Insert
    fun insertSingleSong(logToInsert: MoodModel)

    @Query("SELECT * FROM MoodModel WHERE uid = :logID")
    fun fetchLogByID(logID: Int): MoodModel

    @Query("SELECT * FROM MoodModel")
    fun fetchAll(): List<MoodModel>

    @Query("DELETE FROM MoodModel")
    fun clearTable()

    @Delete
    fun deleteLog(logToBeDeleted: MoodModel)
}