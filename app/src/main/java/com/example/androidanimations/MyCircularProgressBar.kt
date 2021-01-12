package com.example.androidanimations

import android.animation.ObjectAnimator
import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.RectF
import android.util.AttributeSet
import android.view.animation.DecelerateInterpolator
import androidx.annotation.Keep
import androidx.appcompat.widget.AppCompatImageView
import androidx.core.content.ContextCompat
import kotlin.math.min

class MyCircularProgressBar@JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
): AppCompatImageView(context, attrs, defStyleAttr) {


    /**
     * value should be between 1-max
     * */
    private var animatorProgress: Float = 0f
        @Keep
        set(value) {
            if(value in 0f..max){
                field = value
                invalidate()
            }
        }


    /**
     * this is the max progress
     * */
    var max: Float = 100f

    /**
     * start the animation at 12 o'clock
     * */
    private var startAngle: Int = -90
    private val strokeWidth: Float = 4f
    private val rectF: RectF = RectF()
    private val backgroundPaint: Paint = Paint(Paint.ANTI_ALIAS_FLAG)
    private val foregroundPaint: Paint = Paint(Paint.ANTI_ALIAS_FLAG)


    /**
     * Setup for paint objects
     * */
    init{
        backgroundPaint.color = ContextCompat.getColor(context, R.color.black)
        backgroundPaint.style = Paint.Style.STROKE
        backgroundPaint.strokeWidth = strokeWidth

        foregroundPaint.color = ContextCompat.getColor(context, R.color.white)
        foregroundPaint.style = Paint.Style.STROKE
        foregroundPaint.strokeWidth = strokeWidth

    }


    fun setProgressWithAnimation(currentProgress: Float) {
        val objectAnimator = ObjectAnimator.ofFloat(this, "animatorProgress", this.animatorProgress, if(currentProgress>=max) max else currentProgress)
        objectAnimator.apply {
            duration = 1500
            interpolator = DecelerateInterpolator()
            start()
        }
    }


    override fun onDraw(canvas: Canvas?) {
        canvas?.let{
            it.drawOval(rectF, backgroundPaint)
            val angle: Float = 360 * animatorProgress / max
            it.drawArc(rectF, startAngle.toFloat(), angle, false, foregroundPaint)
        }
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        val height = getDefaultSize(suggestedMinimumHeight, heightMeasureSpec)
        val width = getDefaultSize(suggestedMinimumWidth, widthMeasureSpec)
        val min = min(width, height)
        setMeasuredDimension(min, min)
        rectF.set(0 + strokeWidth / 2, 0 + strokeWidth / 2, min - strokeWidth / 2, min - strokeWidth / 2)
    }
}
