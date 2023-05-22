package com.alextos.organize

import android.content.res.Resources
import kotlin.math.round

actual class ScreenInfo actual constructor() {
    private val displayMetrics = Resources.getSystem().displayMetrics

    actual val width: Int = displayMetrics.widthPixels
    actual val height: Int = displayMetrics.heightPixels
    actual val density: Int = round(displayMetrics.density).toInt()
}