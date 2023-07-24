package com.colada.gtn3

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.widget.Toast
import androidx.activity.ComponentActivity


class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.view_main)
    }

    fun sosi(item: MenuItem) {
        Toast.makeText(this, "kill urself" , Toast.LENGTH_SHORT).show()
    }

    fun pidor(item: MenuItem) {
        val d = Log.d("d", "UEBOK!!!!")
        startActivity(Intent(this, view_tickets_list::class.java))
    }

    fun A1_start(item: MenuItem) {
        val intent = Intent(this, view_tickets_list::class.java)
        globalData.currentCategory = "A1"
        intent.putExtra("category", "A1")
        startActivity(intent, null)
    }
}
