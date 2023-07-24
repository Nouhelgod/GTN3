package com.colada.gtn3

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.graphics.Bitmap
import android.util.Log

class task(private val context: Context) {


    lateinit var question: String
    lateinit var description: String
    lateinit var answers: List<String>
    lateinit var rightAnswer: String
    lateinit var image: Bitmap

    var questionsCount = 0
    val db = dbhelper(context)

    fun getTask(cat: String, ticketNumber: Int, questionNumber: Int) {
        val ticketNum = ticketNumber.toString()
        val questionNum = questionNumber.toString()
        question = db.getQuestion(cat, ticketNum, questionNum)
        description = db.getDescription(cat, ticketNum, questionNum)
        answers = db.getAnswers(cat, ticketNum, questionNum)
        rightAnswer = db.getRightAnswer(cat, ticketNum, questionNum)
    }

    fun getQuestionCount(cat: String, ticketNum: Int): Int {

        questionsCount = db.getQuestionsCount(cat, ticketNum.toString())

        return questionsCount
    }
}
