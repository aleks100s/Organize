package com.alextos.organize

import android.os.Build
import android.util.Log

actual class Platform actual constructor() {
    actual val osName: String = "Android"
    actual val osVersion: String = "${Build.VERSION.SDK_INT}"
    actual val deviceModel: String = "${Build.MANUFACTURER} ${Build.MODEL}"
    actual val cpuType: String = Build.SUPPORTED_ABIS.firstOrNull() ?: "Unknown"
    actual val screen: ScreenInfo? = ScreenInfo()

    actual fun logSystemInfo() {
        Log.d("Platform", deviceInfo)
    }
}