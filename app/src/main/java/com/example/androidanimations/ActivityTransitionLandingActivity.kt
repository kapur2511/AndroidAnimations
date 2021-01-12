package com.example.androidanimations

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class ActivityTransitionLandingActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_transition_landing)
    }

    override fun onBackPressed() {
        super.onBackPressed()
        supportFinishAfterTransition()
    }
}