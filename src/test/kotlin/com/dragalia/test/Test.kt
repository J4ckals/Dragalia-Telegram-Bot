package com.dragalia.test

import com.dragaliabot.WikiUrls
import kotlinx.coroutines.runBlocking
import kotlin.test.Test
import kotlin.test.assertEquals

class Test {

    @Test
    fun testAdventurersSearch() = runBlocking {
        val euden = WikiUrls.searchAdventurerByName("Euden")
        assertEquals(1, euden.size)
    }

}
