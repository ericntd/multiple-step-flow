package com.example.multiplestepflow

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View

class MainActivity : AppCompatActivity(), FlowNagivation {
    /*
    The steps could be defined as enum
     */
    private val stepA = "a"
    private val stepB = "b"
    private val steps = listOf(stepA, stepB).shuffled()
    private var currentStep = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /*
        Don't re-render on restart e.g. rotation
         */
        if (savedInstanceState == null) {
            renderStep(currentStep)
        }
    }

    private fun renderStep(i: Int) {
        Log.w("MainActivity", "renderStep $i")
        when (steps[i]) {
            "a" -> {
                val inputA = InputA("some data");
                val fragA = StepAFragment.newInstance(inputA)
                supportFragmentManager.beginTransaction().replace(R.id.fragment_container, fragA).commit()
            }
            "b" -> {
                val input = InputB("some data");
                val frag = StepBFragment.newInstance(input)
                supportFragmentManager.beginTransaction().replace(R.id.fragment_container, frag).commit()
            }
        }
    }

    override fun goNext(outputA: OutputA) {
        /*
         process output A
         */
        println(outputA)
        goToNextStep()
    }

    private fun goToNextStep() {
        currentStep++
        if (currentStep<steps.size) {
            renderStep(currentStep)
        } else {
            println("flow completed")
            findViewById<View>(R.id.done).visibility = View.VISIBLE
            findViewById<View>(R.id.fragment_container).visibility = View.GONE
        }
    }

    override fun goNext(outputB: OutputB) {
        /*
         process output B
         */
        println(outputB)
        goToNextStep()
    }
}