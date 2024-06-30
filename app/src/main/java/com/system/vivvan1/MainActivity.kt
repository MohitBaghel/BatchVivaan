package com.system.vivvan1

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val nine = findViewById<Button>(R.id.nine)
        val eight = findViewById<Button>(R.id.eight)
        val seven  = findViewById<Button>(R.id.eight)
        val six = findViewById<Button>(R.id.six)
        val five = findViewById<Button>(R.id.five)
        val four = findViewById<Button>(R.id.four)
        val three = findViewById<Button>(R.id.eight)
        val two = findViewById<Button>(R.id.two)
        val one = findViewById<Button>(R.id.one)

        val plus = findViewById<Button>(R.id.plus)
        val minus = findViewById<Button>(R.id.minus)
        val mutilple = findViewById<Button>(R.id.mutilple)
        val divide = findViewById<Button>(R.id.divide)
        val equal = findViewById<Button>(R.id.equal)

        var edt1 = findViewById<EditText>(R.id.first_num)
        var edt2 = findViewById<EditText>(R.id.second_num)

        plus.setOnClickListener {
            val num1 =  edt1.text.toString().toInt()
            val num2 =  edt2.text.toString().toInt()
            var result =  add(num1, num2)
            Toast.makeText(this, "Result $result", Toast.LENGTH_SHORT).show()

        }






        // coding
    }


    private fun add( a: Int, b:Int ) : Int{
        return a + b;
    }

    private fun subract( a: Int, b:Int ) : Int{
        return a - b;
    }

    private fun mutilple( a: Int, b:Int ) : Int{
        return a * b;
    }


    private fun divide( a: Int, b:Int ) : Int{
        return a / b;
    }


}