package com.example.kotlinlaba5

import androidx.lifecycle.ViewModel


private const val TAG = "MyViewModel"

class ViewModel {
    class MyViewModel : ViewModel() {

        var countOfLitrs = 0
        var typeOfFuel = "0"

    }
}