package com.hedron.meditate.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.hedron.meditate.Repository.MeditateRepository
import com.hedron.meditate.model.MeditationModel

class HomeViewModel : ViewModel() {


    private val _meditationList = MutableLiveData<ArrayList<MeditationModel>>().apply {
        value = MeditateRepository().getMeditation()
    }

    private val _text = MutableLiveData<String>().apply {
        value = "This is home Fragment"
    }

    val text: LiveData<String> = _text

    val meditationList : LiveData<ArrayList<MeditationModel>> = _meditationList
}