package com.dragaliabot.data

import org.joda.time.DateTime

data class Wyrmprint(
    val BaseId: String,
    val Name: String,
    val NameJP: String,
    val Rarity: String,
    val AmuletType: String,
    val MinHp: Int,
    val MaxHp: Int,
    val MinAtk: Int,
    val MaxAtk: Int,
    val VariationId: String,
    val Abilities11: String,
    val Abilities12: String,
    val Abilities13: String,
    val Abilities21: String,
    val Abilities22: String,
    val Abilities23: String,
    val Abilities31: String,
    val Abilities32: String,
    val Abilities33: String,
    val ArtistCV: String,
    val FlavorText1: String,
    val FlavorText2: String,
    val FlavorText3: String,
    val FlavorText4: String,
    val FlavorText5: String,
    val IsPlayable: Boolean,
    val SellCoin: Int,
    val SellDewPoint: Int,
    val ReleaseDate: String,
    val Obtain: String
) : DragaliaTable {
    val parsedReleaseDate
        get() = DateTime.parse(ReleaseDate)

    data class NestedTitle(val title: Adventurer) {
        data class Cargo(val cargoquery: List<NestedTitle>)
    }
}