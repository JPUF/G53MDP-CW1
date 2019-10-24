package com.example.g53mdp_cw1

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import com.example.g53mdp_cw1.views.FingerPainterView

const val BRUSH_ACTIVITY_REQUEST_CODE = 1
const val COLOR_ACTIVITY_REQUEST_CODE = 2

class MainActivity : AppCompatActivity() {

    lateinit var painter: FingerPainterView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        painter = findViewById(R.id.painter)
    }

    fun goToBrush(view: View) {
        val bundle = Bundle()
        bundle.putInt("brushSize", 1)
        val brushIntent = Intent(this, BrushActivity::class.java)
        brushIntent.putExtras(bundle)
        startActivityForResult(brushIntent, BRUSH_ACTIVITY_REQUEST_CODE)
    }

    fun goToColor(view: View) {
        startActivity(Intent(this, ColorActivity::class.java))

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if(requestCode == BRUSH_ACTIVITY_REQUEST_CODE) {
            if(resultCode == Activity.RESULT_OK) {
                val bundle = data!!.extras
                val brushSize = bundle!!.getInt("brushSize")
                Log.i("MainActivityResult", "Brush Size: $brushSize")
                painter.brushWidth = brushSize

            }
        }

    }
}
