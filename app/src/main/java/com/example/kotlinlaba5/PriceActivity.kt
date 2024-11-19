package com.example.kotlinlaba5

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class PriceActivity : AppCompatActivity() {

    private lateinit var backButton: Button
    private lateinit var priceTextView: TextView
    private var price = 0

    companion object {
        private const val EXTRA = "com.example.kotlinlaba5.PRICE_EXTRA"

        fun newIntent(packageContext: Context, price: Int): Intent {
            return Intent(packageContext, PriceActivity::class.java).apply {
                putExtra(EXTRA, price)
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_price)

        // Получаем цену из Intent
        price = intent.getIntExtra(EXTRA, 0)

        priceTextView = findViewById(R.id.priceTextView)
        displayPrice(price)

        backButton = findViewById<Button>(R.id.backButton)
        backButton.setOnClickListener {
            finish()
        }
    }

    private fun displayPrice(price: Int) {
        priceTextView.text = "Итоговая цена:  " + price.toString()
    }
}
