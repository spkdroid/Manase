package com.dija.manase.di

import android.content.Context
import android.media.MediaPlayer
import com.dija.manase.data.repository.MeditateRepository
import com.dija.manase.data.repository.MusicRepository
import com.dija.manase.data.service.MusicService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {
    @Provides
    @Singleton
    fun provideMeditateRepository(): MeditateRepository {
        return MeditateRepository()
    }

    @Provides
    @Singleton
    fun provideMusicRepository(@ApplicationContext context: Context, musicService: MusicService): MusicRepository {
        return MusicRepository(musicService)
    }

    @Provides
    @Singleton
    fun provideMediaPlayer(): MediaPlayer {
        return MediaPlayer()
    }

}