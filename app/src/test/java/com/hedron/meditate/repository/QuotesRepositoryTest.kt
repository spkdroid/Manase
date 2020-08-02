package com.hedron.meditate.repository

import org.junit.Assert
import org.junit.Test
import com.hedron.meditate.repository.QuotesRepository

class QuotesRepositoryTest {

    @Test
    fun QuotesRepository_Test() {
        var quotesRepository = QuotesRepository()
        Assert.assertTrue(quotesRepository.getQuote().authorText.isNotEmpty())
        Assert.assertTrue(quotesRepository.getQuote().quoteText.isNotEmpty())
    }

}