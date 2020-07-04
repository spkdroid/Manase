package com.hedron.meditate.Repository

import com.hedron.meditate.R
import com.hedron.meditate.model.MeditationModel

class MeditateRepository {
    fun getMeditation(): ArrayList<MeditationModel> {
        var listGuides = ArrayList<MeditationModel>()
        listGuides.add(MeditationModel("Sleep", "Feel the night. Watch its beauty.", R.drawable.sleep))
        listGuides.add(MeditationModel("Self care", "Soothes your soul.", R.drawable.calm))
        listGuides.add(MeditationModel("Breathe", "Stop, relax and breathe.", R.drawable.nature))
        return listGuides
    }
}