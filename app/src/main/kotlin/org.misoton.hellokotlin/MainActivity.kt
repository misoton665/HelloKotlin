package org.misoton.hellokotlin

import android.graphics.Color
import android.graphics.ColorFilter
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.os.Handler
import android.support.v7.app.ActionBarActivity
import android.util.Log
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import android.view.animation.*
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import org.misoton.helloshake.bindView
import java.util.Timer
import kotlin.properties.Delegates

class MainActivity : ActionBarActivity() {
    private val activityRootViewGroup: ViewGroup by bindView(R.id.main_activity_root_view_group)

//    private val smallViewGroup: ViewGroup by bindView(R.id.main_activity_test_view_group)
//
//    private val hello: TextView by bindView(R.id.main_hello_text_view)

    override fun onCreate(savedInstanceState: Bundle?) {
        super<ActionBarActivity>.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val actionBar = getSupportActionBar()
        actionBar.hide()
        activityRootViewGroup.setOnTouchListener(OnSpreadTargetTouchListener(this, activityRootViewGroup, 2000))
//        smallViewGroup.setOnTouchListener(OnSpreadTargetTouchListener(this, smallViewGroup, 2000))
    }
}