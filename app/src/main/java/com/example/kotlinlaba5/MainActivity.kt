package com.example.kotlinlaba5

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.RadioButton
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private val myViewModel: ViewModel.MyViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        var editTextNumber = findViewById<TextView>(R.id.editTextNumber)
        var buttonStart = findViewById<Button>(R.id.buttonStart)
        var button92 = findViewById<RadioButton>(R.id.radioButton92)
        var button95 = findViewById<RadioButton>(R.id.radioButton95)
        var button98 = findViewById<RadioButton>(R.id.radioButton98)



        editTextNumber.text = myViewModel.countOfLitrs

        buttonStart.setOnClickListener {

            val check = when {
                button92.isChecked -> true
                button95.isChecked -> true
                button98.isChecked -> true
                else -> false
            }

            if (editTextNumber.text.toString() != "" && check != false) {

                val price = when {
                    button92.isChecked -> 50 * editTextNumber.text.toString().toInt()
                    button95.isChecked -> 55 * editTextNumber.text.toString().toInt()
                    button98.isChecked -> 57 * editTextNumber.text.toString().toInt()
                    else -> 0
                }

                val intent = PriceActivity.newIntent(this@MainActivity, price)
                startActivity(intent);
                //Toast.makeText(this, price.toString(), Toast.LENGTH_SHORT).show()
            }
            else{
                Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show()
            }
        }
    }


}