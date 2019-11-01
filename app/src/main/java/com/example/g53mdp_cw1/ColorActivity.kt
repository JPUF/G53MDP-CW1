package com.example.g53mdp_cw1

import android.app.Activity
import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View

class ColorActivity : AppCompatActivity() {

    private var color = Color.BLACK

    private lateinit var currentColor: View
    lateinit var bundle: Bundle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_color)

        currentColor = findViewById(R.id.rectangle)

        bundle = intent.extras!!
        color = bundle.getInt("color")
        currentColor.setBackgroundColor(color)
    }

    fun returnToMain(view: View) {
        val resultIntent = Intent()
        bundle.putInt("color", getColorSelection(view.tag.toString()))
        resultIntent.putExtras(bundle)
        setResult(Activity.RESULT_OK, resultIntent)
        finish()
    }

    private fun getColorSelection(tag: String): Int {
        return when (tag) {
            "red" -> Color.RED
            "green" -> Color.GREEN
            "blue" -> Color.BLUE
            "yellow" -> Color.YELLOW
            "lightred" -> Color.argb(255, 255, 102, 102)
            "lightgrey" -> Color.LTGRAY
            "grey" -> Color.GRAY
            "black" -> Color.BLACK
            else -> Color.BLACK
        }
    }
}
