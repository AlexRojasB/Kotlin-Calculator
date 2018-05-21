package com.example.android.calculator

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.math.exp

class MainActivity : AppCompatActivity() {
    var newExpression = "0"
    var oldExpression = ""
    var expressionList: MutableList<Double> = mutableListOf()
    var operationList: MutableList<String> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun onNumberEvent(view:View){
        val buSelect = view as Button
        if(newExpression == "0"){
            newExpression = ""
        }
        when(buSelect.id){
            R.id.btnOne -> {
                newExpression += "1"
            }
            R.id.btnTwo -> {
                newExpression += "2"
            }
            R.id.btnThree -> {
                newExpression += "3"
            }
            R.id.btnFour -> {
                newExpression += "4"
            }
            R.id.btnFive -> {
                newExpression += "5"
            }
            R.id.btnSix -> {
                newExpression += "6"
            }
            R.id.btnSeven -> {
                newExpression += "7"
            }
            R.id.btnEight -> {
                newExpression += "8"
            }
            R.id.btnNine -> {
                newExpression += "9"
            }
            R.id.btnDot -> {
                if(!newExpression.contains(".")){
                    newExpression += "."
                }
            }
            R.id.btnSymbols -> {
                if(!newExpression.contains("-")) {
                    newExpression = "-$newExpression"
                }else{
                    newExpression.replace("-","")
                }
            }
        }
        etDisplayNumbers.text = "$oldExpression$newExpression"
    }

    fun onOperationEvent(view:View){
        expressionList.add(newExpression.toDouble())
        val buOperation = view as Button
        oldExpression = oldExpression + newExpression + buOperation.text
        newExpression = ""
        when (buOperation.id){
            R.id.btnDivide -> {
                operationList.add("divide")
            }
            R.id.btnPlus -> {
                operationList.add("sum")
            }
            R.id.btnMinus -> {
                operationList.add("subtract")
            }
            R.id.btnTimes -> {
                operationList.add("times")
            }
        }
    }

    fun OnGetResult(view:View){
        expressionList.add(newExpression.toDouble())
        var steps = 1
        do {
            var foundExpression = false
            loop@ for (i in operationList.indices){
                if(steps == 1 && operationList[i] == "times"){
                    expressionList[i] = expressionList[i] * expressionList[i+1]
                    foundExpression = true
                }else if(steps == 1 && operationList[i] == "divide"){
                    expressionList[i] = expressionList[i] / expressionList[i+1]
                    foundExpression = true
                }else if(steps==2 && operationList[i] == "subtract"){
                    expressionList[i] = expressionList[i] - expressionList[i+1]
                    foundExpression = true
                }else if(steps==2 && operationList[i] == "sum"){
                    expressionList[i] = expressionList[i] + expressionList[i+1]
                    foundExpression = true
                }
                if (foundExpression){
                    expressionList.removeAt(i+1)
                    operationList.removeAt(i)
                    break@loop
                }
            }
            if(!foundExpression){
                steps++
            }
        }while(steps != 3)

        etDisplayNumbers.text = expressionList.first().toString()
    }

    fun onOperationClear(view: View){
        expressionList.clear()
        operationList.clear()
        newExpression = "0"
        oldExpression = ""
        etDisplayNumbers.text = "0"
    }
}
