package com.dija.manase.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.dija.manase.data.model.MeditateModel
import com.dija.manase.data.repository.MeditateRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(repository: MeditateRepository) : ViewModel() {
    val meditationList : LiveData<List<MeditateModel>> = repository.getMeditation().asLiveData()
}