package cn.cyanbukkit.growwheat.utils

import org.bukkit.Location
import org.bukkit.entity.EntityType
import org.bukkit.entity.LivingEntity
import org.bukkit.entity.Villager

object SpawnEntityHandle {

    fun spawnVillage(loc: Location) : LivingEntity {
        val entity = loc.world.spawnEntity(loc, EntityType.VILLAGER ) as Villager
        entity.setBaby()
        return entity
    }

}