package com.alextos.organize

import kotlinx.cinterop.alloc
import kotlinx.cinterop.memScoped
import kotlinx.cinterop.ptr
import platform.Foundation.NSLog
import platform.Foundation.NSString
import platform.Foundation.NSUTF8StringEncoding
import platform.Foundation.stringWithCString
import platform.UIKit.UIDevice
import platform.UIKit.UIUserInterfaceIdiomPad
import platform.UIKit.UIUserInterfaceIdiomPhone
import platform.posix.uname
import platform.posix.utsname
import kotlin.native.Platform

actual class Platform actual constructor() {
    actual val osName = when (UIDevice.currentDevice.userInterfaceIdiom) {
        UIUserInterfaceIdiomPhone -> "iOS"
        UIUserInterfaceIdiomPad -> "iPadOS"
        else -> Platform.osFamily.name
    }
    actual val osVersion = UIDevice.currentDevice.systemVersion
    actual val deviceModel: String
        get() {
            memScoped {
                val systemInfo: utsname = alloc()
                uname(systemInfo.ptr)
                return NSString.stringWithCString(systemInfo.machine, encoding = NSUTF8StringEncoding) ?: "Unknown"
            }
        }

    actual val cpuType = Platform.cpuArchitecture.name
    actual val screen: ScreenInfo? = ScreenInfo()

    actual fun logSystemInfo() {
        NSLog(deviceInfo)
    }
}