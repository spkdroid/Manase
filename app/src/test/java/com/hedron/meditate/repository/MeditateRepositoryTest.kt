package com.hedron.meditate.repository

import org.junit.Assert
import org.junit.Before
import org.junit.Test


class MeditateRepositoryTest {

    lateinit var meditateRepository: MeditateRepository

    @Before
    fun setUp() {
        meditateRepository = MeditateRepository()
    }


    @Test
    fun checkMeditationRepository() {
        Assert.assertTrue(meditateRepository.getMeditation().isNotEmpty())
    }
}