package com.example.kotlinlaba5

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

val EXTRA_ANSWER_IS_TRUE = "com.bignerdranch.android.geoquiz.answer_is_true"

class PriceActivity : AppCompatActivity() {

    private lateinit var backButton: Button
    private lateinit var priceTextView: TextView
    private var price = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_price)

        price = intent.getIntExtra(EXTRA_ANSWER_IS_TRUE,0)

        priceTextView = findViewById(R.id.priceTextView)
        priceTextView.text = price.toString();


        backButton = findViewById<Button>(R.id.backButton)
        backButton.setOnClickListener {
            this.finish()
        }
    }

    companion object {
        fun newIntent(packageContext: Context, price: Int): Intent {
            return Intent(packageContext, PriceActivity::class.java).apply {
                putExtra(EXTRA_ANSWER_IS_TRUE, price)
            }
        }
    }
}