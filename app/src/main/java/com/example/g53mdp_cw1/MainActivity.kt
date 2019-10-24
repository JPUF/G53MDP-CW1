package com.example.g53mdp_cw1

import android.app.Activity
import android.content.Intent
import android.graphics.Color
import android.graphics.Paint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import com.example.g53mdp_cw1.views.FingerPainterView

const val BRUSH_ACTIVITY_REQUEST_CODE = 1
const val COLOR_ACTIVITY_REQUEST_CODE = 2

class MainActivity : AppCompatActivity() {

    lateinit var painter: FingerPainterView

    private var brushSize = 1
    private var brushShape = Paint.Cap.ROUND
    private var brushColor = Color.BLACK

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        painter = findViewById(R.id.painter)
        brushSize = painter.brushWidth
        brushShape = painter.brush
    }

    fun goToBrush(view: View) {
        val bundle = Bundle()
        bundle.putInt("brushSize", brushSize)
        bundle.putSerializable("brushShape", brushShape)
        val brushIntent = Intent(this, BrushActivity::class.java)
        brushIntent.putExtras(bundle)
        startActivityForResult(brushIntent, BRUSH_ACTIVITY_REQUEST_CODE)
    }

    fun goToColor(view: View) {
        val bundle = Bundle()
        bundle.putInt("color", Color.BLUE)

        val colorIntent = Intent(this, ColorActivity::class.java)
        colorIntent.putExtras(bundle)
        startActivityForResult(colorIntent, COLOR_ACTIVITY_REQUEST_CODE)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if(requestCode == BRUSH_ACTIVITY_REQUEST_CODE) {
            if(resultCode == Activity.RESULT_OK) {
                val bundle = data!!.extras
                brushSize = bundle!!.getInt("brushSize")
                Log.i("MainActivityResult", "Brush Size: $brushSize")
                painter.brushWidth = brushSize

                brushShape = bundle!!.getSerializable("brushShape") as Paint.Cap
                painter.brush = brushShape
            }
        } else if(requestCode == COLOR_ACTIVITY_REQUEST_CODE) {
            val bundle = data!!.extras
            brushColor = bundle!!.getInt("color")
            painter.colour = brushColor
        }

    }
}
