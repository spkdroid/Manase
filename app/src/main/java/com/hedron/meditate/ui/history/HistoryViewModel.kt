package com.hedron.meditate.ui.history

import android.content.Context
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.hedron.meditate.model.MoodModel
import com.hedron.meditate.repository.MoodRepository
import com.hedron.meditate.repository.database.MoodDatabase
import kotlinx.android.synthetic.main.fragment_dashboard.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class HistoryViewModel : ViewModel() {
    // TODO: Implement the ViewModel

    var moodHistoryList: MutableLiveData<List<MoodModel>> = MutableLiveData()

    suspend fun getOfferList(c: Context) {
        GlobalScope.launch {
            val moodDao = MoodDatabase.getDatabase(c).moodDaoAccess()
            var repository = MoodRepository(moodDao)
            moodHistoryList.value = repository.getAll()
        }
     }

}
