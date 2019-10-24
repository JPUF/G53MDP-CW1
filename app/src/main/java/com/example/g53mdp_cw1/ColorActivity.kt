package com.example.g53mdp_cw1

import android.app.Activity
import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class ColorActivity : AppCompatActivity() {

    private var color = Color.BLACK

    lateinit var bundle: Bundle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_color)

        bundle = intent.extras!!
        color = bundle!!.getInt("color")
    }

    fun returnToMain(view: View) {
        val resultIntent = Intent()
        bundle.putInt("color", Color.MAGENTA)
        resultIntent.putExtras(bundle)
        setResult(Activity.RESULT_OK, resultIntent)
        finish()
    }
}
