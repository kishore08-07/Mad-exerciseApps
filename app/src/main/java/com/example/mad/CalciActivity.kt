package com.example.mad

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.button.MaterialButton
import net.objecthunter.exp4j.ExpressionBuilder

class CalciActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var inputText: TextView
    private lateinit var outputText: TextView
    private val inputExpression= StringBuilder()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calci)

        inputText=findViewById(R.id.input)
        outputText=findViewById(R.id.output)

        val buttonIds= arrayOf(
            R.id.btn0,R.id.btn1,R.id.btn2,R.id.btn3,R.id.btn4,R.id.btn5,R.id.btn6,R.id.btn7,R.id.btn8,R.id.btn9 ,
            R.id.btnc,R.id.btnac,R.id.btneq,R.id.btndiv,R.id.btnmul,R.id.btnadd,R.id.btnsub,R.id.btnopen,R.id.btnclose
        )
        for(id in buttonIds){
            findViewById<MaterialButton>(id).setOnClickListener(this)
        }
    }

    override fun onClick(v: View) {
        val button= v as MaterialButton
        val buttonText= button.text.toString()

        when(buttonText){
            "AC" ->{
                inputExpression.clear()
                outputText.text="0"
            }
            "C" ->{
                if(inputExpression.isNotEmpty()){
                    inputExpression.deleteCharAt(inputExpression.length-1)
                }
                outputText.text="0"
            }
            "=" ->{
                outputText.text=evaluateExp(inputExpression.toString())
            }
            else ->{
                inputExpression.append(buttonText)
            }
        }
        inputText.text=inputExpression.toString()
    }

    private fun evaluateExp(exp: String):String{
        return try{
            val result=ExpressionBuilder(exp).build().evaluate()
            result.toString()
        }catch(e:Exception){
            "ERROR"
        }
    }
}