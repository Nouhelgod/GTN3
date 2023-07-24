package com.colada.gtn3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ImageView
import android.widget.ListView
import android.widget.TextView

class TaskActivity : AppCompatActivity() {

    lateinit var imageView: ImageView
    lateinit var questionTextView: TextView
    lateinit var answerListView: ListView
    lateinit var continueButtonView: Button
    lateinit var task: task
    var currentQuestionNum = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_task)

        imageView = findViewById(R.id.task_image)
        questionTextView = findViewById(R.id.task_question)
        answerListView = findViewById(R.id.task_answers_list)
        continueButtonView = findViewById(R.id.task_continue_button)
        task = task(this)
        buildTask()
    }

    fun nextQuestion(view: View) {
        currentQuestionNum += 1
        buildTask()
    }


    fun buildTask() {
        task.getTask(globalData.currentCategory, globalData.currentTicket, currentQuestionNum)
        questionTextView.text = task.question

        val adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, task.answers)
        answerListView.adapter = adapter
        answerListView.setOnItemClickListener {
             parent, view, position, id->

            if (position.toString() == task.rightAnswer) {

            }
        }
    }
}