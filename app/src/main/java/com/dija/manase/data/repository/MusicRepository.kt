package com.dija.manase.data.repository

import com.dija.manase.data.service.MusicService
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MusicRepository @Inject constructor(private val musicService: MusicService) {

     suspend fun startMusicService(title: String) {
        musicService.playMusic(title)
    }

    suspend fun stopMusicService() {
        musicService.stopMusic()
    }

}
