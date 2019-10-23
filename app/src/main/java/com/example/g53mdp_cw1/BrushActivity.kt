package com.example.g53mdp_cw1

import android.graphics.Paint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.SeekBar
import android.widget.TextView

class BrushActivity : AppCompatActivity() {

    lateinit var sizeSeekBar: SeekBar
    lateinit var sizeTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_brush)

        sizeSeekBar = findViewById(R.id.sizeSeek)
        sizeTextView = findViewById(R.id.sizeText)
        sizeSeekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(p0: SeekBar?, i: Int, b: Boolean) {
                val sizeValue = i + 1
                Log.i("seekbar", "$sizeValue")
                val textString = "Size: $sizeValue"
                sizeTextView.text = textString
            }

            override fun onStartTrackingTouch(p0: SeekBar?) {

            }

            override fun onStopTrackingTouch(p0: SeekBar?) {

            }

        })
    }
}

