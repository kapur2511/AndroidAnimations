package com.example.androidanimations

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
    }

    fun objectAnimatorActivity(view: View){
        startActivity(Intent(this,ObjectAnimatorActivity::class.java))
    }

    fun propertyAnimatorActivity(view: View){
        startActivity(Intent(this,PropertyAnimatorActivity::class.java))
    }

    fun motionLayoutActivity(view: View){
        startActivity(Intent(this,MotionLayoutActivity::class.java))
    }

    fun activityTransitionsActivity(view: View){
        startActivity(Intent(this,ActivityTransitions::class.java))
    }
}