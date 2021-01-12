package com.example.androidanimations

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity

class PropertyAnimatorActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_property_animator)
    }


    fun fullAlpha(view: View) {
        view.animate().alpha(0f)
    }

    fun halfAlpha(view: View) {
        view.animate().alpha(0.5f)
    }

    fun moveAndAlpha(view: View) {
        val anim = view.animate().alpha(0.5f).rotation(90f).x(50f).y(150f)
        anim.start()
    }
}