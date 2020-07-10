package com.hedron.meditate.ui.history

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.hedron.meditate.model.MoodModel
import com.hedron.meditate.repository.MoodRepository
import com.hedron.meditate.repository.database.MoodDatabase

class HistoryViewModel : ViewModel() {
    // TODO: Implement the ViewModel

    var moodHistoryList: MutableLiveData<List<MoodModel>> = MutableLiveData()

    fun getOfferList(c: Context) {
            val moodDao = MoodDatabase.getDatabase(c).moodDaoAccess()
            var repository = MoodRepository(moodDao)
            moodHistoryList.postValue(repository.allMoods)
     }

}
