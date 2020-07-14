package com.hedron.meditate.repository

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
        quotesList.add(QuoteModel("Somewhere, something incredible is waiting to be known.","Carl Sagan"))
        quotesList.add(QuoteModel("Don’t worry about failure; you only have to be right once.","Drew Houston"))
        quotesList.add(QuoteModel("You carry the passport to your own happiness","Diane von Furstenberg"))
        quotesList.add(QuoteModel("Never let success get to your head and never let failure get to your heart.","Drake"))
        return quotesList[(0 until quotesList.size).random()]
    }
}