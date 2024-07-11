package cn.cyanbukkit.growwheat.utils

import org.bukkit.Location

data class Region(
    var pos1 : Location,
    var pos2 : Location,
) {

    var x = NumberPair(pos1.blockX, pos2.blockX)
    var z = NumberPair(pos1.blockZ, pos2.blockZ)

    // 根据方向获取头和尾部的Location
    fun


}
