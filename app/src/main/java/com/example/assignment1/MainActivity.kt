package com.example.assignment1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val spiner: Spinner = findViewById(R.id.spinner)
        val v1: TextView = findViewById(R.id.view1)
        val v2: TextView = findViewById(R.id.view2)
        val num1: EditText = findViewById(R.id.num1)
        val num2: EditText = findViewById(R.id.num2)
        val b: Button = findViewById(R.id.button)
        val res: TextView = findViewById(R.id.result)
        var opt = arrayOf("metric", "imperial")
        var flag:String = "metric"
        spiner.adapter = ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,opt)
        spiner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                flag = opt.get(p2)
                if(opt.get(p2) == "metric"){
                    v1.text = "height(cm)"
                    v2.text = "weight(kg)"
                }
                else{
                    v1.text = "height(inches)"
                    v2.text = "weight(lbs)"
                }
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("Not yet implemented")
            }
        }
        b.setOnClickListener(){view ->

            if(flag == "metric"){
                var h = num1.text.toString().toFloat()/ 100
                var w = num2.text.toString().toFloat()
                var bmim = w/(h*h)
                res.text = bmim.toString()
            }
            else{
                var h = num1.text.toString().toFloat()/ 12
                var w = num2.text.toString().toFloat()
                var bmii = (703*w)/(h*h)
                res.text = bmii.toString()
            }
        }
    }
}