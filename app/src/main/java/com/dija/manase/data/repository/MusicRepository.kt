package com.dija.manase.data.repository

import android.content.Context
import android.content.Intent
import android.content.res.AssetFileDescriptor
import com.dija.manase.data.service.MusicService
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MusicRepository @Inject constructor(private val context: Context) {

    // Function to get the audio file based on the title
    fun getAudioFile(title: String): AssetFileDescriptor? {
        return try {
            when (title) {
                "Sleep" -> context.assets.openFd("thunder.mp3")
                "Self care" -> context.assets.openFd("nature.mp3")
                "Breathe" -> context.assets.openFd("breath.mp3")
                "Veena" -> context.assets.openFd("veena.mp3")
                "Piano" -> context.assets.openFd("piano.mp3")
                "Violin" -> context.assets.openFd("violin.mp3")
                else -> null
            }
        } catch (e: Exception) {
            null
        }
    }

    // Function to start the music service
    fun startMusicService(title: String) {
        val intent = Intent(context, MusicService::class.java)
        val audioFile = getAudioFile(title)
        audioFile?.let {
            intent.putExtra("title", it)  // Pass the audio file to the service
            context.startService(intent)
        }
    }

    // Function to stop the music service
    fun stopMusicService() {
        val intent = Intent(context, MusicService::class.java)
        context.stopService(intent)
    }

    // Function to pause the music
    fun pauseMusic() {
        val intent = Intent(context, MusicService::class.java)
        intent.action = "PAUSE"
        context.startService(intent)
    }

    // Function to resume the music
    fun resumeMusic() {
        val intent = Intent(context, MusicService::class.java)
        intent.action = "RESUME"
        context.startService(intent)
    }
}
