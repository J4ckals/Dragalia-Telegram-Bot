package com.dragaliabot.data

import org.joda.time.DateTime

data class Dragon(
    val BaseId: String,
    val Id: String,
    val Name: String,
    val FullName: String,
    val NameJP: String,
    val Title: String,
    val TitleJP: String,
    val Obtain: String,
    val Rarity: Int,
    val ElementalType: String,
    val ElementalTypeId: Int,
    val VariationId: Int,
    val IsPlayable: Boolean,
    val MinHp: Int,
    val MaxHp: Int,
    val MinAtk: Int,
    val MaxAtk: Int,
    val Skill1: String,
    val SkillName: String,
    val SkillDescription: String,
    val Abilities11: String,
    val Abilities12: String,
    val Abilities21: String,
    val Abilities22: String,
    val ProfileText: String,
    val FavoriteType: Int,
    val JapaneseCV: String,
    val EnglishCV: String,
    val SellCoin: Int,
    val SellDewPoint: Int,
    val MoveSpeed: Float,
    val DashSpeedRatio: Float,
    val TurnSpeed: Float,
    val IsTurnToDamageDir: Boolean,
    val MoveType: Int,
    val IsLongRange: Boolean,
    val ReleaseDate: String,
    val Availability: String
) : DragaliaTable {

    val parsedReleaseDate
        get() = DateTime.parse(ReleaseDate)

    data class NestedTitle (val title: Dragon) {
        data class Cargo (val cargoquery: List<NestedTitle>)
    }
}
