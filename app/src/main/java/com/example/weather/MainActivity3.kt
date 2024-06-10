package com.example.weather
import android.annotation.SuppressLint
import android.content.Intent
import com.example.weather.MainActivity2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity3 : AppCompatActivity() {

    private lateinit var backButton: Button
    private lateinit var results: TextView
    var data: String = ""
//complete page scren
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)


        backButton = findViewById(R.id.back)
        results = findViewById(R.id.results)



        results = findViewById(R.id.results)


        for (days in daysList.withIndex()) {

            var index = days.index

//This where i use parrallel array
            val row = "Day : ${days.value}\nMinimum :${minList[index]}\nMaximum :${maxList[index]}\nCondition :${conditionList[index]}"

            data += "$row\n\n\n\n"


        }

        println(data)


        results.text = data




        backButton.setOnClickListener {
            val intent = Intent(this, MainActivity2::class.java)

            startActivity(intent)
        }
    }
}