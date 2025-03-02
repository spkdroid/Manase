package com.dija.manase.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.dija.manase.data.repository.TestRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class MainViewModel @Inject constructor(repository: TestRepository) : ViewModel() {
    val data: LiveData<String> = repository.getData()
}