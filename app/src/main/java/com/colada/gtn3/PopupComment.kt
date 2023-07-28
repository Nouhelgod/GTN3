package com.colada.gtn3

import android.animation.ArgbEvaluator
import android.animation.ValueAnimator
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.PopupWindow
import android.widget.TextView
import androidx.core.graphics.ColorUtils

class PopupComment : AppCompatActivity() {
    private var popupText = ""
    private lateinit var commentTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_popup_comment)

        commentTextView = findViewById(R.id.popup_text)

//        val bundle = intent.extras
//        popupText = intent?.getStringExtra("popupText").toString()
//        commentTextView.text = popupText




    }




}