package com.example.calculatoroslab

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import javax.script.ScriptEngine
import javax.script.ScriptEngineManager
import javax.script.ScriptException

class MainActivity : AppCompatActivity() {

    lateinit var workingsTV : TextView
    lateinit var resultsTV : TextView
    var working : String = "";

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        workingsTV = findViewById<TextView>(R.id.workings)
        resultsTV = findViewById<TextView>(R.id.results)
    }

    fun setWorkings(value: String){
        working += value
        workingsTV.setText(working)
    }

    fun resetOnClick(view: View) {
        workingsTV.setText("")
        resultsTV.setText("")
        working = ""
    }
    fun pangkatOnClick(view: View) {
        setWorkings("^")
    }
    fun bagiOnClick(view: View) {
        setWorkings("/")
    }
    fun sevenOnClick(view: View) {
        setWorkings("7")
    }
    fun eightOnClick(view: View) {
        setWorkings("8")
    }
    fun nineOnClick(view: View) {
        setWorkings("9")
    }
    fun kaliOnClick(view: View) {
        setWorkings("*")
    }
    fun fourOnClick(view: View) {
        setWorkings("4")
    }
    fun fiveOnClick(view: View) {
        setWorkings("5")
    }
    fun sixOnClick(view: View) {
        setWorkings("6")
    }
    fun kurangOnClick(view: View) {
        setWorkings("-")
    }
    fun oneOnClick(view: View) {
        setWorkings("1")
    }
    fun twoOnClick(view: View) {
        setWorkings("2")
    }
    fun thereOnClick(view: View) {
        setWorkings("3")
    }
    fun tambahOnClick(view: View) {
        setWorkings("+")
    }
    fun titikOnClick(view: View) {
        setWorkings(".")
    }
    fun zeroOnClick(view: View) {
        setWorkings("0")
    }
    fun samdenganOnClick(view: View) {
        var result: Any? = null

        val engine : ScriptEngine = ScriptEngineManager().getEngineByName("rhino")

        try {
            result = engine.eval(working)
        }catch (ex : ScriptException){
            Toast.makeText(this, "Invalid input", Toast.LENGTH_SHORT).show()
        }

        if(result != null)
            resultsTV.setText((result).toString())
    }
}