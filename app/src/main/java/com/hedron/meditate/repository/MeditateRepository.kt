package com.hedron.meditate.repository

import com.hedron.meditate.R
import com.hedron.meditate.model.MeditationModel

class MeditateRepository {
    fun getMeditation(): ArrayList<MeditationModel> {
        var listGuides = ArrayList<MeditationModel>()
        listGuides.add(MeditationModel("Sleep", "Nap time is my happy hour", R.drawable.sleep_icon))
        listGuides.add(MeditationModel("Self care", "Giving yourself permission to pause", R.drawable.self_icon))
        listGuides.add(MeditationModel("Breathe", "Inhale peace and exhale worry", R.drawable.breath_icon))
        return listGuides
    }
}