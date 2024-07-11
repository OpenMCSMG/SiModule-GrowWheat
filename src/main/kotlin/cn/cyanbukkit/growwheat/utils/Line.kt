package cn.cyanbukkit.growwheat.utils

import org.bukkit.Location
import kotlin.math.abs

data class Line(
    val start: Location,
    val end: Location
) {
    fun getLineHasBlockSize() : Int {
        // 返回这个条线有多少个方块
        return abs(start.blockX - end.blockX) + abs(start.blockZ - end.blockZ) + 1
    }
}