package com.colada.gtn3

import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ImageView
import android.widget.ListView
import android.widget.PopupWindow
import android.widget.TextView
import org.w3c.dom.Text
import kotlin.reflect.typeOf

class TaskActivity : AppCompatActivity() {

    lateinit var imageView: ImageView
    lateinit var questionTextView: TextView
    lateinit var answerListView: ListView
    lateinit var task: task
    lateinit var descriptionView: TextView
    var currentQuestionNum = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_task)

        imageView = findViewById(R.id.task_image)
        questionTextView = findViewById(R.id.task_question)
        answerListView = findViewById(R.id.task_answers_list)
//        descriptionView = findViewById(R.id.task_description)
        task = task(this)
        buildTask()
    }

    fun nextQuestion() {
        currentQuestionNum += 1

        if (currentQuestionNum != 9) {
            buildTask()
        } else {
            finish()
        }

    }


    fun buildTask() {
        task.getTask(globalData.currentCategory, globalData.currentTicket, currentQuestionNum)
        questionTextView.text = task.question
        Log.d("TASK", "Right answer: ${task.rightAnswer}")

        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, task.answers)
        answerListView.adapter = adapter
        answerListView.setOnItemClickListener {
             _, _, position, _->

            Log.d("TASK", "Got answer: $position")

            if (position.toString() == task.rightAnswer) {
                Log.d("TASK", "OK")
                nextQuestion()
            } else {
                Log.d("TASK", "WRONG")
                val window = PopupWindow(this)
                val view = layoutInflater.inflate(R.layout.activity_popup_comment, null)
                window.contentView = view
                descriptionView = view.findViewById(R.id.popup_text)
                descriptionView.text = task.description
                window.isOutsideTouchable = true
                window.isFocusable = true
                window.setIgnoreCheekPress()

                val continueButtonView = view.findViewById<Button>(R.id.popup_continue_button)
                continueButtonView.setOnClickListener{
                    window.dismiss()
                }

                window.showAtLocation(answerListView, Gravity.CENTER, 0, 0)


            }
        }
    }


    fun showPopup(): PopupWindow {
        val inflater = getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val view = inflater.inflate(R.layout.activity_popup_comment, null)

        return PopupWindow(view, ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT)
    }
}