package com.dija.manase.data.service

import android.app.*
import android.content.Context
import android.content.Intent
import android.content.res.AssetFileDescriptor
import android.media.MediaPlayer
import android.os.Build
import android.os.IBinder
import androidx.annotation.RequiresApi
import androidx.core.app.NotificationCompat
import com.dija.manase.R
import dagger.hilt.android.AndroidEntryPoint

class MusicService : Service() {

    lateinit var mediaPlayer: MediaPlayer

    private var title: String? = null

    override fun onCreate() {
        super.onCreate()
        mediaPlayer = MediaPlayer()
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        when (intent?.action) {
            "PLAY" -> {
                title = intent.getStringExtra("title")
                startForegroundService()
                playMusic()
            }
            "STOP" -> {
                stopMusic()
                stopSelf()
            }
        }
        return START_STICKY
    }

    @RequiresApi(Build.VERSION_CODES.O)
    private fun startForegroundService() {
        val channelId = "music_service_channel"
        val notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        val channel = NotificationChannel(channelId, "Music Playback", NotificationManager.IMPORTANCE_LOW)
        notificationManager.createNotificationChannel(channel)

        val stopIntent = Intent(this, MusicService::class.java).apply { action = "STOP" }
        val stopPendingIntent = PendingIntent.getService(this, 0, stopIntent, PendingIntent.FLAG_IMMUTABLE)

        val notification = NotificationCompat.Builder(this, channelId)
            .setContentTitle("Playing Music")
            .setContentText(title ?: "Unknown Track")
            .setSmallIcon(R.drawable.globe_icon)
            .addAction(android.R.drawable.ic_secure, "Stop", stopPendingIntent)
            .setOngoing(true)
            .build()

        startForeground(1, notification)
    }

    private fun playMusic() {
        stopMusic()
        val descriptor = getAudioFile(title ?: "")

        descriptor?.let {
            mediaPlayer = MediaPlayer().apply {
                setDataSource(it.fileDescriptor)
                isLooping = true
                prepare()
                start()
            }
            it.close()
        }
    }

    private fun stopMusic() {
        if (mediaPlayer.isPlaying) {
            mediaPlayer.stop()
        }
        mediaPlayer.reset()
    }

    override fun onDestroy() {
        stopMusic()
        mediaPlayer.release()
        super.onDestroy()
    }

    fun getAudioFile(title: String): AssetFileDescriptor? {
        return try {
            when (title) {
                "Sleep" -> assets.openFd("thunder.mp3")
                "Self care" -> assets.openFd("nature.mp3")
                "Breathe" -> assets.openFd("breath.mp3")
                "Veena" -> assets.openFd("veena.mp3")
                "Piano" -> assets.openFd("piano.mp3")
                "Violin" -> assets.openFd("violin.mp3")
                else -> null
            }
        } catch (e: Exception) {
            null
        }
    }

    override fun onBind(intent: Intent?): IBinder? = null
}
