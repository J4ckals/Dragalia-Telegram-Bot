package com.dragaliabot.data

import kotlin.reflect.full.memberProperties

interface DragaliaTable {
    val members
        get () = this::class.memberProperties.map { it.name }.filter { "parsedReleaseDate" !in it }
}