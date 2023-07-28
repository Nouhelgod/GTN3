package com.colada.gtn3

import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteQueryBuilder
import android.util.Log
import androidx.core.database.getStringOrNull
import com.readystatesoftware.sqliteasset.SQLiteAssetHelper


class dbhelper(context: Context?) :
    SQLiteAssetHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

    private var db = writableDatabase

    companion object {
        private const val DATABASE_NAME = "tickets.db"
        private const val DATABASE_VERSION = 2
    }

    fun getQuestion(category: String, ticketNum: String, questionNum: String): String {
        val args = arrayOf(ticketNum, questionNum)
        val sql = "select questionText from " + category + " where ticketNum = ? and questionNum = ?"
        Log.d("dbhelper", sql)
        val q = db.rawQuery(sql, args, null)
        q.moveToFirst()
        val questionText = q.getString(0)
        q.close()

        return questionText
    }

    fun getDescription(category: String, ticketNum: String, questionNum: String): String {
        val args = arrayOf(ticketNum, questionNum)
        val sql = "select comment from " + category + " where ticketNum = ? and questionNum = ?"
        Log.d("dbhelper", sql)
        val q = db.rawQuery(sql, args, null)
        q.moveToFirst()
        val descriptionText = q.getString(0)
        q.close()

        return descriptionText
    }

    fun getAnswers(category: String, ticketNum: String, questionNum: String): MutableList<String> {
        var listOfAnswerText = mutableListOf<String>()
        val args = arrayOf(ticketNum, questionNum)
        val sql = "select answerText from " + category + "_answ where ticketNum = ? and questionNum = ?"
        Log.d("dbhelper", sql)

        val q = db.rawQuery(sql, args, null)
        q.moveToFirst()

        listOfAnswerText.add(q.getString(0))
        while ( q.moveToNext()) {
            listOfAnswerText.add(q.getString(0))
        }

        q.close()

        return listOfAnswerText
    }


    fun getRightAnswer(category: String, ticketNum: String, questionNum: String): String {
        val args = arrayOf(ticketNum, questionNum)
        val sql = "select rightAnswer from $category where ticketNum = ? and questionNum = ?"
        Log.d("dbhelper", sql)
        val q = db.rawQuery(sql, args, null)
        q.moveToFirst()
        var rightAnswerStr = q.getString(0)
        var rightAnswerInt = rightAnswerStr.toInt() - 1
        rightAnswerStr = rightAnswerInt.toString()

        q.close()

        return rightAnswerStr
    }


    fun getTickets(cat: String): MutableList<String> {
        val sql = "select distinct ticketNum from $cat"
        Log.d("dbhelper", sql)
        val args = arrayOf<String>()
        val q = db.rawQuery(sql, args, null)

        val listOfTicketNums = mutableListOf<String>()
        q.moveToFirst()
        listOfTicketNums.add(q.getString(0))
        while (q.moveToNext()) {
            listOfTicketNums.add(q.getString(0))
        }
        q.close()

        return listOfTicketNums
    }

    fun getQuestionsCount(category: String, ticketNum: String): Int {
        val sql = "select distinct questionNum from " + category + "where ticketNum = ?"
        Log.d("dbhelper", sql)
        val args = arrayOf(ticketNum)
        val q = db.rawQuery(sql, args, null)

        val count = q.count
        q.close()
        return count

    }
}