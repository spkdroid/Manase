package com.dija.manase.data.repository

import com.dija.manase.R
import com.dija.manase.data.model.MeditateModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MeditateRepository @Inject constructor() {

    fun getMeditation(): Flow<List<MeditateModel>> = flow {
        val listGuides = listOf(
            MeditateModel("Sleep", "Nap time is my happy hour", R.drawable.sleep_icon),
            MeditateModel("Self care", "Giving yourself permission to pause", R.drawable.self_icon),
            MeditateModel("Breathe", "Inhale peace and exhale worry", R.drawable.breath_icon),
            MeditateModel("Piano", "Music Speaks when words can't", R.drawable.piano_icon),
            MeditateModel("Veena", "SITAR The Essence of Indian music", R.drawable.veena_icon),
            MeditateModel("Violin", "Happiness is a thing to be practiced", R.drawable.violin_icon)
        )
        emit(listGuides)  // Emit the list as Flow
    }
}
