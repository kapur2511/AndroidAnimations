package com.example.androidanimations

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.animation.AnimationUtils

class ObjectAnimatorActivity : AppCompatActivity() {

    private val view: View by lazy {
        findViewById(R.id.viewToBeAnimated)
    }

    private val circularProgress: MyCircularProgressBar by lazy {
        findViewById(R.id.circularProgress)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun loadFromXml(view: View){
        val animation = AnimationUtils.loadAnimation(this, R.anim.alpha)
        view.startAnimation(animation)
    }

    fun fullAlpha(view: View) {
        val anim = ObjectAnimator.ofFloat(view, "alpha", 0f)
        anim.duration = 2000
        anim.start()
    }

    fun halfAlpha(view: View) {
        val anim = ObjectAnimator.ofFloat(view, "alpha", 0f, 0.5f)
        anim.duration = 2000
        anim.start()
    }

    fun toAndFroAlpha(view: View) {
        if(true){
            loadFromXml(view)
        } else {
            val anim = ObjectAnimator.ofFloat(view, "alpha", 0.5f, 0f, 0.5f, 1f)
            anim.duration = 2000
            anim.start()
        }
    }

    fun moveAndAlpha(view: View) {
        val anim = ObjectAnimator.ofFloat(view, "alpha", 1f, 0.2f, 1f)
        anim.duration = 2000
        val animX = ObjectAnimator.ofFloat(view, "x", 50f)
        animX.duration = 2000
        val animY = ObjectAnimator.ofFloat(view, "y", 150f)
        animY.duration = 2000
        val set = AnimatorSet()
        set.playTogether(anim, animX, animY)

        set.start()
    }

    fun progressAnimation(view: View) {
        circularProgress.setProgressWithAnimation(50f)
    }
}