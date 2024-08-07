package cn.cyanbukkit.growwheat.utils

import cn.cyanbukkit.growwheat.cyanlib.launcher.CyanPluginLauncher.cyanPlugin
import org.bukkit.Location
import org.bukkit.World
import org.bukkit.entity.LivingEntity
import org.bukkit.scheduler.BukkitRunnable
import kotlin.math.asin
import kotlin.math.atan2

class Walk(
    val liveEntity: LivingEntity,
    val whileRun: (LivingEntity) -> Unit,
    val spawnLocation: Location,
    val targetLocation: Location,
    val endRUn: (World) -> Unit = { },
) {

    // 走到目标位置
    fun walkUseTP(speed: Double = 1.0) {
        val direction = targetLocation.toVector().subtract(spawnLocation.toVector()).normalize()
        val distance = spawnLocation.distance(targetLocation)
        val steps = (distance * 10).toInt()
        liveEntity.velocity = direction.multiply(speed)
        object : BukkitRunnable() {
            var step = 0
            override fun run() {
                if (step >= steps || targetLocation.distance(liveEntity.location) < 0.5) {
                    liveEntity.health = 0.0
                    this.cancel()
                    return
                }
                val newLocation = spawnLocation.clone().add(direction.clone().multiply(step.toDouble() / 10.0))
                val yaw = Math.toDegrees(atan2(direction.z, direction.x)).toFloat() - 90
                val pitch = Math.toDegrees(asin(direction.y)).toFloat()
                newLocation.yaw = yaw
                newLocation.pitch = pitch
                liveEntity.teleport(newLocation)
                whileRun(liveEntity)
                step++
            }
        }.runTaskTimer(cyanPlugin, 0L, 1L)
    }

}