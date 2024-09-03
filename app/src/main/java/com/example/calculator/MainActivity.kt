package com.example.calculator

import android.icu.text.DecimalFormat
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import org.mariuszgromada.math.mxparser.Expression

class MainActivity : AppCompatActivity() {

    private lateinit var inputTextView: TextView
    private lateinit var resultTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        inputTextView = findViewById(R.id.inputTV)  // Initialize your TextView
        resultTextView = findViewById(R.id.resultsTV)  // Initialize your TextView

        val btnClear = findViewById<Button>(R.id.clear_bt)

        btnClear.setOnClickListener {
            // Code to execute when the button is clicked
             inputTextView.text=""
            resultTextView.text=""
             }


        val btnBracketLeft = findViewById<Button>(R.id.left_parenthesis_bt)
        // Set on-click listener
        btnBracketLeft.setOnClickListener {
            inputTextView.text=addToInputText("(")
            // Code to execute when the button is clicked
        }

        val btnBracketRight = findViewById<Button>(R.id.right_parenthesis_bt)

        btnBracketRight.setOnClickListener {
            inputTextView.text=addToInputText(")")

        }

        val btn0 = findViewById<Button>(R.id.bt_0)

        btn0.setOnClickListener {
            inputTextView.text=addToInputText("0")

        }
        val btn1 = findViewById<Button>(R.id.bt_1)

        btn1.setOnClickListener {
            inputTextView.text=addToInputText("1")

        }
        val btn2 = findViewById<Button>(R.id.bt_2)

        btn2.setOnClickListener {
            inputTextView.text=addToInputText("2")

        }
        val btn3 = findViewById<Button>(R.id.bt_3)

        btn3.setOnClickListener {
            inputTextView.text=addToInputText("3")

        }
        val btn4 = findViewById<Button>(R.id.bt_4)

        btn4.setOnClickListener {
            inputTextView.text=addToInputText("4")

        }
        val btn5 = findViewById<Button>(R.id.bt_5)

        btn5.setOnClickListener {
            inputTextView.text=addToInputText("5")

        }
        val btn6 = findViewById<Button>(R.id.bt_6)

        btn6.setOnClickListener {
            inputTextView.text=addToInputText("6")

        }
        val btn7 = findViewById<Button>(R.id.bt_7)

        btn7.setOnClickListener {
            inputTextView.text=addToInputText("7")

        }
        val btn8 = findViewById<Button>(R.id.bt_8)

        btn8.setOnClickListener {
            inputTextView.text=addToInputText("8")

        }
        val btn9 = findViewById<Button>(R.id.bt_9)

        btn9.setOnClickListener {
            inputTextView.text=addToInputText("9")

        }

        val btnDot = findViewById<Button>(R.id.dot_bt)

         btnDot.setOnClickListener {
            inputTextView.text=addToInputText(".")

        }
        val btnDivision = findViewById<Button>(R.id.division_sign_bt)

        btnDivision.setOnClickListener {
            inputTextView.text=addToInputText("÷")

        }
        val btnMultiplay = findViewById<Button>(R.id.times_sign_bt)

        btnMultiplay.setOnClickListener {
            inputTextView.text=addToInputText("×")

        }
        val btnMinus = findViewById<Button>(R.id.minus_sign_bt)

        btnMinus.setOnClickListener {
            inputTextView.text=addToInputText("-")

        }
        val btnPlus = findViewById<Button>(R.id.addition_sign_bt)

        btnPlus.setOnClickListener {
            inputTextView.text=addToInputText("+")

        }

        val btnEqule = findViewById<Button>(R.id.equal_bt)

        btnEqule.setOnClickListener {
            showResult()

        }


    }

    private fun addToInputText(buttonValue: String):String
    {
     return "${inputTextView.text}$buttonValue"
    }

    private fun getInputExpression():String
    {
        var expression=inputTextView.text.replace(Regex("÷"),"/")
            expression=expression.replace(Regex("×"),"*")
        return expression
    }
    private fun  showResult() {
        try {
            val expression = getInputExpression()
            val result = Expression(expression).calculate()
            if (result.isNaN()) {
                //show error message
                resultTextView.text = "Error"
                resultTextView.setTextColor(ContextCompat.getColor(this, R.color.red))
            } else {
                // showResult
                resultTextView.text = DecimalFormat("0.######").format(result).toString()
                resultTextView.setTextColor(ContextCompat.getColor(this, R.color.green))
            }
        } catch (e: Exception) {
            //show error message

            resultTextView.text = "Error"
            resultTextView.setTextColor(ContextCompat.getColor(this, R.color.red))


        }
    }


}