package com.dija.manase.data.service

import android.content.Context
import android.content.res.AssetFileDescriptor
import android.media.MediaPlayer
import android.util.Log
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MusicService @Inject constructor(@ApplicationContext private val context: Context) {

    private var mediaPlayer: MediaPlayer? = null

    suspend fun playMusic(title: String) {
        stopMusic() // Stop any ongoing playback before playing new one

        val descriptor = getAudioFile(title) ?: run {
            Log.e("MusicService", "Error: Could not load audio file for title: $title")
            return
        }

        withContext(Dispatchers.IO) {
            descriptor.use { afd ->
                mediaPlayer = MediaPlayer().apply {
                    setDataSource(afd.fileDescriptor, afd.startOffset, afd.length)
                    isLooping = true
                    prepare() // Preparing the media player
                    start()
                }
            }
        }
    }

    suspend fun stopMusic() {
        withContext(Dispatchers.IO) { // Stop and reset player on background thread
            mediaPlayer?.apply {
                if (isPlaying) stop()
                reset()
                release()
            }
            mediaPlayer = null
        }
    }

    private suspend fun getAudioFile(title: String): AssetFileDescriptor? = withContext(Dispatchers.IO) {
        return@withContext try {
            context.assets.openFd(
                when (title) {
                    "Sleep" -> "thunder.mp3"
                    "Self care" -> "nature.mp3"
                    "Breathe" -> "breath.mp3"
                    "Veena" -> "veena.mp3"
                    "Piano" -> "piano.mp3"
                    "Violin" -> "violin.mp3"
                    else -> return@withContext null
                }
            )
        } catch (e: Exception) {
            Log.e("MusicService", "Error loading asset file: ${e.message}")
            null
        }
    }
}