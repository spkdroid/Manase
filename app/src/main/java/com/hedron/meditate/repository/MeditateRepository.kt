package com.hedron.meditate.repository

import com.hedron.meditate.R
import com.hedron.meditate.model.MeditationModel

class MeditateRepository {
    fun getMeditation(): ArrayList<MeditationModel> {
        var listGuides = ArrayList<MeditationModel>()
        listGuides.add(MeditationModel("Sleep", "Nap time is my happy hour", R.drawable.sleep_icon))
        listGuides.add(MeditationModel("Self care", "Giving yourself permission to pause", R.drawable.self_icon))
        listGuides.add(MeditationModel("Breathe", "Inhale peace and exhale worry", R.drawable.breath_icon))
        listGuides.add(MeditationModel("Piano", "Music Speaks when word's can't", R.drawable.piano))
        listGuides.add(MeditationModel("Veena", "SITAR The Essence of Indian music", R.drawable.veena))
        listGuides.add(MeditationModel("Violin","Happiness is a thing to be practiced",R.drawable.violin_icon))
        return listGuides
    }
}