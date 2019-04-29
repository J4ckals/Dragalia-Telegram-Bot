package com.dragaliabot.data

import org.joda.time.DateTime
import kotlin.reflect.full.memberProperties

data class Adventurer(
    var Id: String,
    var Name: String,
    var FullName: String,
    var NameJP: String,
    var NameTC: String,
    var Title: String,
    var TitleJP: String,
    var TitleTC: String,
    var WeaponType: String,
    var WeaponTypeId: Int,
    var Rarity: Int,
    var ElementalType: String,
    var ElementalTypeId: Int,
    var CharaType: String,
    var VariationId: Int,
    var MinHp3: Int,
    var MinHp4: Int,
    var MinHp5: Int,
    var MaxHp: Int,
    var PlusHp0: Int,
    var PlusHp1: Int,
    var PlusHp2: Int,
    var PlusHp3: Int,
    var PlusHp4: Int,
    var McFullBonusHp5: Int,
    var MinAtk3: Int,
    var MinAtk4: Int,
    var MinAtk5: Int,
    var MaxAtk: Int,
    var PlusAtk0: Int,
    var PlusAtk1: Int,
    var PlusAtk2: Int,
    var PlusAtk3: Int,
    var PlusAtk4: Int,
    var McFullBonusAtk5: Int,
    var MinDef: Int,
    var DefCoef: Int,
    var Skill1Name: String,
    var Skill2Name: String,
    var Abilities11: String,
    var Abilities12: String,
    var Abilities13: String,
    var Abilities14: String,
    var Abilities21: String,
    var Abilities22: String,
    var Abilities23: String,
    var Abilities24: String,
    var Abilities31: String,
    var Abilities32: String,
    var Abilities33: String,
    var Abilities34: String,
    var ExAbilityData1: String,
    var ExAbilityData2: String,
    var ExAbilityData3: String,
    var ExAbilityData4: String,
    var ExAbilityData5: String,
    var ManaCircleName: String,
    var JapaneseCV: String,
    var EnglishCV: String,
    var Description: String,
    var IsPlayable: Boolean,
    var MaxFriendshipPoint: Int,
    var Obtain: String,
    var ReleaseDate: String,
    var Availability: String
) {

    companion object {
        val members = Adventurer::class.memberProperties.map { it.name }.filter { "parsedReleaseDate" !in it }
    }

    val parsedReleaseDate
        get() = DateTime.parse(ReleaseDate)

    data class NestedTitle (var title: Adventurer) {
        data class Cargo (var cargoquery: List<NestedTitle>)
    }
}
