package com.hedron.meditate.Repository

import com.hedron.meditate.R
import com.hedron.meditate.model.MeditationModel
import com.hedron.meditate.model.QuoteModel

class QuotesRepository {

    fun getQuote():QuoteModel {
        var quotesList = ArrayList<QuoteModel>()
        quotesList.add(QuoteModel("The purpose of our lives is to be happy.","Dalai Lama"))
        quotesList.add(QuoteModel("Life is what happens when you’re busy making other plans.","John Lennon"))
        quotesList.add(QuoteModel("Get busy living or get busy dying.","Stephen King"))
        quotesList.add(QuoteModel("Never let the fear of striking out keep you from playing the game","Babe Ruth"))
        quotesList.add(QuoteModel("If you want to live a happy life, tie it to a goal, not to people or things.","Albert Einstein"))
        quotesList.add(QuoteModel("Not how long, but how well you have lived is the main thing","Seneca"))
        quotesList.add(QuoteModel("In order to write about life first you must live it.","Ernest Hemingway"))
        quotesList.add(QuoteModel("Turn your wounds into wisdom.","Oprah Winfrey"))
        return quotesList[(0 until 7).random()]
    }
}