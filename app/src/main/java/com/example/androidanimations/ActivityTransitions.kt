package com.example.androidanimations

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.core.app.ActivityOptionsCompat

class ActivityTransitions : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_transitions)
    }

    fun startTransition(view: View) {
        val options = ActivityOptionsCompat.makeSceneTransitionAnimation(
            this,
            view,
            "fullImage"
        ).toBundle()
        val intent = Intent(this, ActivityTransitionLandingActivity::class.java)
        startActivity(intent, options)
    }

    fun startTransitionClipReveal(view: View) {
        val options = ActivityOptionsCompat.makeClipRevealAnimation(
            view,
            view.bottom,
            view.left,
            view.width,
            view.height
        ).toBundle()
        val intent = Intent(this, ActivityTransitionLandingActivity::class.java)
        startActivity(intent, options)
    }
}