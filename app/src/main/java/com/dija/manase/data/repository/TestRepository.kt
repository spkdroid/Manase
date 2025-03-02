package com.dija.manase.data.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class TestRepository {
    fun getData(): LiveData<String> {
        return MutableLiveData("Hello from Repository")
    }
}