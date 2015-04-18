package org.misoton.helloshake

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.View
import android.widget.Toast
import kotlin.properties.Delegates

fun Activity.showToast(message: String) {
    Toast.makeText(this, message, Toast.LENGTH_LONG).show()
}

fun <T : Any> Any.dLog(value: T) {
    val parts = this.javaClass.toString().split("\\.")
    Log.d(parts.get(parts.size() - 1), value.toString())
}

fun <T : View> Activity.bindView(resId: Int): BindViewDelegate<T> {
    return BindViewDelegate(this, resId)
}

fun Activity.transitionActivity(className: String, finish: Boolean = false) {
    val classFullName = this.getPackageName() + className
    val intent = Intent(this, Class.forName(classFullName)).setAction(Intent.ACTION_VIEW)
    startActivity(intent)
    if (finish) {
        finish()
    }
}

class BindViewDelegate<T : View>(val activity: Activity, val resId: Int) {
    private var value: T? = null

    [suppress("UNCHECKED_CAST")]
    fun get(thisRef: Any, prop: PropertyMetadata): T {
        if (value == null) {
            value = activity.findViewById(resId) as T
        }
        return value!!
    }

    fun set(thisRef: Any, prop: PropertyMetadata, value: T) {
        this.value = value
    }
}