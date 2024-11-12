package com.example.kotlinlaba5

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {


    private val myViewModel: ViewModel.MyViewModel by viewModels()
    
    private lateinit var editTextNumber: EditText
    private lateinit var buttonStart: Button
    private lateinit var button92: RadioButton
    private lateinit var button95: RadioButton
    private lateinit var button98: RadioButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)


    }
}