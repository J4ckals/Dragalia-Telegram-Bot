package com.dragaliabot.database.definitions

import org.jetbrains.exposed.dao.IntIdTable

object AdventurersTable : IntIdTable() {
    val page = varchar("page", 1024)
    val name = varchar("name", 255)
    val fullName = varchar("fullname", 255)
    val title = varchar("title", 255)
    val weaponTypeId = reference("weaponTypeId", WeaponsTable)
    val stars = varchar("stars", 5)
    val elementalTypeId = reference("elementalType", ElementalTypeTable)
    val characterType = varchar("character", 255)
    val minHp3 = integer("minHp3")
    val minHp4 = integer("minHp4")
    val minHp5 = integer("minHp5")
    val maxHp = integer("maxHp")
    val plusHp0 = integer("plusHp0")
    val plusHp1 = integer("plusHp1")
    val plusHp2 = integer("plusHp2")
    val plusHp3 = integer("plusHp3")
    val plusHp4 = integer("plusHp4")
    val mcFullBonusHp5 = integer("mcFullBonusHp5")
    val minAtk3 = integer("minAtk3")
    val minAtk4 = integer("minAtk4")
    val minAtk5 = integer("minAtk5")
    val maxAtk = integer("maxAtk")
    val plusAtk0 = integer("plusAtk0")
    val plusAtk1 = integer("plusAtk1")
    val plusAtk2 = integer("plusAtk2")
    val plusAtk3 = integer("plusAtk3")
    val plusAtk4 = integer("plusAtk4")
    val mcFullBonusAtk5 = integer("mcFullBonusAtk5")
    val minDef = integer("minDef")
    val defCoef = integer("defCoef")
    val skill1Id = reference("ability1Id", AbilitiesTable)
    val skill2Id = reference("ability2Id", AbilitiesTable)


}