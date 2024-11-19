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


private const val REQUEST_CODE_CHEAT = 0

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

        var typeOfFuel = when{
            button92.isChecked -> myViewModel.typeOfFuel = "92"
            button95.isChecked -> myViewModel.typeOfFuel = "95"
            button98.isChecked -> myViewModel.typeOfFuel = "98"
            else -> myViewModel.typeOfFuel = "0"
        }

        editTextNumber.text = myViewModel.countOfLitrs


        buttonStart.setOnClickListener {


            var price = when{
                button92.isChecked -> 50 * myViewModel.countOfLitrs.toInt()
                button95.isChecked -> 55 * myViewModel.countOfLitrs.toInt()
                button98.isChecked -> 57 * myViewModel.countOfLitrs.toInt()
                else -> 0
            }

            if (myViewModel.typeOfFuel != "0" && myViewModel.countOfLitrs.toInt() > 0) {


                val intent = PriceActivity.newIntent(this@MainActivity, price)
                //intent.putExtra("price", "price")
                //startActivityForResult(intent, REQUEST_CODE_CHEAT)
                startActivity(intent);
            }
            else{
                Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show()
            }
        }
    }


}