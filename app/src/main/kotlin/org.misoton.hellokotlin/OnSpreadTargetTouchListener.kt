package org.misoton.hellokotlin

import android.content.Context
import android.graphics.Color
import android.os.Handler
import android.util.Log
import android.view.Gravity
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.AnimationSet
import android.view.animation.ScaleAnimation
import android.view.animation.TranslateAnimation
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.LinearLayout
import org.misoton.helloshake.dLog

class OnSpreadTargetTouchListener(val context: Context, val targetView: ViewGroup, val duration: Long = 1000, val magnification: Float = 1.0F) : View.OnTouchListener {

    private var touchCnt = 0

    private val colorList: List<Int> = listOf(
            Color.rgb(255, 152, 0),
            Color.rgb(63, 81, 181),
            Color.rgb(255, 235, 59),
            Color.rgb(139, 195, 74),
            Color.rgb(233, 30, 99),
            Color.rgb(0, 188, 212))

    private val speed: Long = duration

    override fun onTouch(v: View?, event: MotionEvent): Boolean {
        val animateView = ImageView(context)
        val color = colorList[touchCnt % colorList.size()]
        val nowCnt = touchCnt + 1
        animateView.setImageDrawable(context.getDrawable(R.drawable.circle))
        animateView.setScaleType(ImageView.ScaleType.FIT_CENTER)
        animateView.setColorFilter(color)
        targetView.addView(animateView)

        startAnimation(animateView, event.getX(), event.getY())

        Handler().postDelayed({ ->
            targetView.setBackgroundColor(color)

            targetView.removeView(animateView)
        }, speed + 1000)
        touchCnt++
        return false
    }

    fun startAnimation(targetView: View, startX: Float, startY: Float) {
        val animation = AnimationSet(true)

        val spreadAnimation = ScaleAnimation(0.0F, 2000.0F, 0.0F, 2000.0F,
                Animation.RELATIVE_TO_SELF, 0.5F,
                Animation.RELATIVE_TO_SELF, 0.5F)
        spreadAnimation.setDuration(speed)

        val moveAnimation = TranslateAnimation(0.0F, startX - targetView.getX(), 0.0F, startY - targetView.getY())

        animation.addAnimation(spreadAnimation)
        animation.addAnimation(moveAnimation)
        animation.setFillAfter(true)
        targetView.startAnimation(animation)

        dLog("target X: ${targetView.getX()} Y: ${targetView.getY()}")
    }

}