package com.alextos.organize

import platform.CoreGraphics.CGRectGetHeight
import platform.CoreGraphics.CGRectGetWidth
import platform.UIKit.UIScreen

actual class ScreenInfo actual constructor() {
    actual val width = CGRectGetWidth(UIScreen.mainScreen.nativeBounds).toInt()
    actual val height = CGRectGetHeight(UIScreen.mainScreen.nativeBounds).toInt()
    actual val density = UIScreen.mainScreen.scale.toInt()
}