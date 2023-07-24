package com.colada.gtn3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class CustomListView : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_custom_list_view)

        var text = intent.getStringExtra("category")
    }
}