package com.system.vivvan1

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class SecondActivity : AppCompatActivity() {
    private lateinit var healthTv : TextView;
    private lateinit var bg : LinearLayout;
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_second)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }



        val btn = findViewById<Button>(R.id.calculate)
        val weightEt = findViewById<EditText>(R.id.weight_et)
        val ftEt = findViewById<EditText>(R.id.heightft_et)
        val inchEt = findViewById<EditText>(R.id.inch_et)
        healthTv = findViewById<TextView>(R.id.health_tv)
        bg = findViewById(R.id.bg_ll)

        btn.setOnClickListener {
            if(weightEt.text.toString().isNotEmpty() && ftEt.text.toString().isNotEmpty() && inchEt.text.toString().isNotEmpty()){

                val wt = (weightEt.text.toString()).toDouble();
                val ft = (ftEt.text.toString()).toDouble();
                val inch = (inchEt.text.toString()).toDouble();

                calculateBmi(wt, ft, inch);

            }
        }


    }

    fun calculateBmi(wt : Double, ft : Double, inch : Double){

        val totalInch = (ft *12) + inch;
        val totalcm = totalInch * 2.54;
        val totalM = totalcm/ 100;

        val bmi =  wt/ (totalM * totalM);

        if(bmi > 25){
            healthTv.text = "You are Overweight";
            bg.setBackgroundColor(resources.getColor(R.color.yellow))
            Toast.makeText(this, "You are Overweight", Toast.LENGTH_SHORT).show()
        }  else if(bmi < 18){
            healthTv.text = "You are Underweight";
            bg.setBackgroundColor(resources.getColor(R.color.red))
            Toast.makeText(this, "You are Underweight", Toast.LENGTH_SHORT).show()
        } else {
            healthTv.text = "You are Fit";
            bg.setBackgroundColor(resources.getColor(R.color.blue))
            Toast.makeText(this, "You are Fit", Toast.LENGTH_SHORT).show()
        }


    }
}