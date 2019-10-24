package com.example.g53mdp_cw1

import android.app.Activity
import android.content.Intent
import android.graphics.Paint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.SeekBar
import android.widget.TextView

class BrushActivity : AppCompatActivity() {

    lateinit var sizeSeekBar: SeekBar
    lateinit var sizeTextView: TextView
    lateinit var bundle: Bundle
    var brushSize: Int = 1
    var textString = "Size: "

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_brush)

        bundle = intent.extras!!
        brushSize = bundle!!.getInt("brushSize")

        sizeSeekBar = findViewById(R.id.sizeSeek)
        sizeTextView = findViewById(R.id.sizeText)
        textString = "Size: $brushSize"
        sizeTextView.text = textString

        sizeSeekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(p0: SeekBar?, i: Int, b: Boolean) {
                brushSize = i + 1
                Log.i("seekbar", "$brushSize")
                textString = "Size: $brushSize"
                sizeTextView.text = textString
            }

            override fun onStartTrackingTouch(p0: SeekBar?) {

            }

            override fun onStopTrackingTouch(p0: SeekBar?) {

            }

        })
    }

    fun returnToMain(view: View) {
        val resultIntent = Intent()
        bundle.putInt("brushSize", brushSize)
        resultIntent.putExtras(bundle)
        setResult(Activity.RESULT_OK, resultIntent)
        finish()
    }
}

