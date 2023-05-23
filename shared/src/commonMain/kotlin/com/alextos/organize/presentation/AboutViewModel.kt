package com.alextos.organize.presentation

import com.alextos.organize.Platform
import kotlin.math.max
import kotlin.math.min

class AboutViewModel: BaseViewModel() {
    data class RowItem(
        val title: String,
        val subtitle: String
    )

    private val platform = Platform()

    private fun makeRowItems(platform: Platform): List<RowItem> {
        val rowItems = mutableListOf(
            RowItem("Operating System", "${platform.osName} ${platform.osVersion}"),
            RowItem("Device", platform.deviceModel),
            RowItem("CPU", platform.cpuType)
        )
        platform.screen?.let {
            rowItems.add(RowItem("Display", "${max(it.width, it.height)}x${min(it.width, it.height)} @${it.density}x"))
        }
        return rowItems
    }

    val items: List<RowItem> = makeRowItems(platform)
}