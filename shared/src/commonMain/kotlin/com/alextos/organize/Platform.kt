package com.alextos.organize

expect class Platform() {
    val osName: String
    val osVersion: String
    val deviceModel: String
    val cpuType: String
    val screen: ScreenInfo?
}

val Platform.deviceInfo: String
    get() {
        val result = StringBuilder("($osName; $osVersion; $deviceModel; ")
        screen?.let {
            result.append("${it.width}x${it.height} @${it.density}x; ")
        }
        result.append("$cpuType)")
        return result.toString()
    }

fun Platform.logSystemInfo() {
    Logger.log(deviceInfo, "Platform", LogLevel.DEBUG)
}