package com.hedron.meditate.ui.calendar

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.hedron.meditate.model.MoodModel
import com.hedron.meditate.repository.MoodRepository
import com.hedron.meditate.repository.database.MoodDatabase
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class CalendarViewModel : ViewModel() {
    // TODO: Implement the ViewModel
    var moodHistoryForDate: MutableLiveData<List<MoodModel>> = MutableLiveData()

    fun getMoodStatsForDate(ctx: Context,date:String) {
        GlobalScope.launch {
            val moodDao = MoodDatabase.getDatabase(ctx).moodDaoAccess()
            var repository = MoodRepository(moodDao).getMoodByDate(date)
            moodHistoryForDate.postValue(repository)
        }
    }

}
