package org.misoton.hellokotlin

import android.graphics.Canvas
import android.graphics.ColorFilter
import android.graphics.drawable.Drawable
import android.view.View

class SpreadDrawable(val targetView: View) : Drawable() {

    override fun draw(canvas: Canvas) {
        throw UnsupportedOperationException()
    }

    override fun setAlpha(alpha: Int) {
        throw UnsupportedOperationException()
    }

    override fun setColorFilter(cf: ColorFilter?) {
        throw UnsupportedOperationException()
    }

    override fun getOpacity(): Int {
        throw UnsupportedOperationException()
    }
}