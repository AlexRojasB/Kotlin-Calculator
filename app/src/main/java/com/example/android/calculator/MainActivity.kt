package com.example.android.calculator

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun onNumberEvent(view:View){
        val buSelect = view as Button
        val buClickValue:String = "0"
        when(buSelect.id){
            bu0.id -> {

            }
        }
    }
}
