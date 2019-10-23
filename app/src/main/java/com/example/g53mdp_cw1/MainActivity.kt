package com.example.g53mdp_cw1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun goToBrush(view: View) {
        startActivity(Intent(this, BrushActivity::class.java))
    }

    fun goToColor(view: View) {
        startActivity(Intent(this, ColorActivity::class.java))
    }
}
