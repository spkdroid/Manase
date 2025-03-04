package com.dija.manase.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import com.dija.manase.data.repository.MusicRepository

@HiltViewModel
class MusicViewModel @Inject constructor(
    private val musicRepository: MusicRepository
) : ViewModel() {

    private val _isMusicPlaying = MutableLiveData<Boolean>(false)
    val isMusicPlaying: LiveData<Boolean> = _isMusicPlaying

    suspend fun toggleMusic(title: String) {
        if (_isMusicPlaying.value == true) {
            musicRepository.stopMusicService()
            _isMusicPlaying.value = false
        } else {
            musicRepository.startMusicService(title)
            _isMusicPlaying.value = true
        }
    }

}
