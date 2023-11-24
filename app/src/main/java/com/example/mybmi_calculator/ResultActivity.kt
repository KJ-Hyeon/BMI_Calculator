package com.example.mybmi_calculator

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import kotlin.math.pow
import kotlin.math.round
import kotlin.math.roundToInt

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val height = intent.getIntExtra("height", 0 )
        val weight = intent.getIntExtra("weight", 0 )

        //BMI 계산식
        var value = weight / (height/100.0).pow(2.0)
        value = round(value*10)/10

        var resultText = " "
        var resImage = 0
        var resColor = 0

        if (value < 18.5) {
            resultText = "저체중"
            resImage = R.drawable.level1
            resColor = Color.YELLOW
        } else if(value >= 18.5 && value < 23.0) {
            resultText = "정상 체중"
            resImage = R.drawable.level2
            resColor = Color.GREEN
        } else if(value >= 23.0 && value < 25.0) {
            resultText = "과체중"
            resImage = R.drawable.level3
            resColor = Color.BLACK
        } else if(value >= 25.0 && value < 30.0) {
            resultText = "경도 비만"
            resImage = R.drawable.level4
            resColor = Color.CYAN
        } else if(value >= 30.0 && value < 35.0) {
            resultText = "중정도 비만"
            resImage = R.drawable.level5
            resColor = Color.MAGENTA
        } else {
            resultText = "고도 비만"
            resImage = R.drawable.level6
            resColor = Color.RED
        }

        val tvResValue = findViewById<TextView>(R.id.tv_resValue)
        val tvResText = findViewById<TextView>(R.id.tv_resText)
        val ivResImage = findViewById<ImageView>(R.id.iv_resImage)
        val btnBack = findViewById<Button>(R.id.btn_resBack)

        tvResValue.text = value.toString()
        tvResText.text = resultText
        tvResText.setTextColor(resColor)
        ivResImage.setImageResource(resImage)

        btnBack.setOnClickListener {
            finish()
        }
        
    }
}