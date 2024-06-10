package com.example.weather

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

var daysList = mutableListOf<String>()
var conditionList = mutableListOf<String>()
var minList = mutableListOf<Int>()
var maxList = mutableListOf<Int>()

class MainActivity2 : AppCompatActivity() {

    private lateinit var detailButton: Button
    private lateinit var exitsButton: Button
    private lateinit var clearButton: Button
    private lateinit var submitButton: Button

    private lateinit var averageView: TextView

    private lateinit var min: EditText
    private lateinit var max: EditText

    private lateinit var daysSpinner: Spinner
    private lateinit var conditionSpinner: Spinner

    var weekDays =
        listOf<String>("Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday")

    var conditions =
        listOf<String>("sunny", "cloudy", "Overcast", "raining", "foggy", "lightning", "windy")



    var minimum: Int = 0
    var maximum: Int = 0
    var average: Int = 0

    var selectedDay: String = ""
    var selectedCondition: String = ""

    var  totalAmount :Int = 0
    var numberOfDays : Int = 0

    fun avergeForWeek(){

        numberOfDays = minList.size

        var currentAmount = minimum + maximum

        totalAmount += currentAmount

        average = (totalAmount/numberOfDays)
    }


    // @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
//for the drop down list
        val adapterDay: ArrayAdapter<String> =
            ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, weekDays)
        val adapterCondition: ArrayAdapter<String> =
            ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, conditions)

        detailButton = findViewById(R.id.details)
        exitsButton = findViewById(R.id.exit2)
        clearButton = findViewById(R.id.clear2)
        submitButton = findViewById(R.id.submit)

        daysSpinner = findViewById(R.id.daysSpinner)
        conditionSpinner = findViewById(R.id.conditionSpinner)

        daysSpinner.setAdapter(adapterDay)
        conditionSpinner.setAdapter(adapterCondition)

        min = findViewById(R.id.min)
        max = findViewById(R.id.max)
        averageView = findViewById(R.id.average)


        exitsButton.setOnClickListener {
            finishAffinity()
        }


//Submit and clear vavluues
        submitButton.setOnClickListener {

            if(min.text.toString() == "" || min.text.toString()  == ""){

                averageView.text = "Please enter every thing "
            }else{
                minimum = min.text.toString().toInt()
                maximum = max.text.toString().toInt()

                selectedDay = daysSpinner.getSelectedItem().toString();
                selectedCondition = conditionSpinner.getSelectedItem().toString();


                daysList.add(selectedDay)
                conditionList.add(selectedCondition)

                minList.add(minimum)
                maxList.add(maximum)

                println(minList)
                println(maxList)
                println(conditionList)
                println(daysList)

                //Clear
                min.text.clear()
                max.text.clear()
                conditionSpinner.setSelection(0);
                daysSpinner.setSelection(0);

                avergeForWeek()

                //The current average for the week
                averageView.text = "The average for the week is $average degrees"
            }



        }

        clearButton.setOnClickListener {
            //Clear
            min.text.clear()
            max.text.clear()
            conditionSpinner.setSelection(0);
            daysSpinner.setSelection(0);
        }

        detailButton.setOnClickListener {

            val intent = Intent(this, MainActivity3::class.java)

            startActivity(intent)
        }


    }
}