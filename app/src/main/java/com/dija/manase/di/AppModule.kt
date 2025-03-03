package com.dija.manase.di

import com.dija.manase.data.repository.MeditateRepository
import com.dija.manase.data.repository.TestRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideRepository(): TestRepository {
        return TestRepository()
    }

    @Provides
    @Singleton
    fun provideMeditateRepository(): MeditateRepository {
        return MeditateRepository()
    }
}