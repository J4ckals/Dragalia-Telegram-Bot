package com.dragaliabot

import com.dragaliabot.data.Adventurer
import com.dragaliabot.utils.append
import io.ktor.client.HttpClient
import io.ktor.client.engine.apache.Apache
import io.ktor.client.features.json.GsonSerializer
import io.ktor.client.features.json.JsonFeature
import io.ktor.client.features.json.JsonSerializer
import io.ktor.client.request.get
import io.ktor.client.response.HttpResponse
import io.ktor.http.*

object WikiUrls {

    val httpClient = HttpClient(Apache) {
        install(JsonFeature) {
            serializer = GsonSerializer()
        }
    }

    val host = "dragalialost.gamepedia.com"
    val protocol = URLProtocol.HTTPS
    val apiPath = "api.php"
    val limit = 500
    val baseParameters = Parameters.build {
        append("action", "cargoquery")
        append("format", "json")
        append("limit", limit)
    }

    fun buildWhereClause(field: String, searchQuery: String) = "$field LIKE \"$searchQuery%\""

    suspend fun searchAdventurerByName(name: String) = httpClient.get<Adventurer.NestedTitle.Cargo> {
        url {
            host = WikiUrls.host
            protocol = WikiUrls.protocol
            path(apiPath)
            parameters.appendAll(baseParameters)
            parameters.append("tables", "Adventurers")
            parameters.append("where", buildWhereClause("Name", name))
        }
    }.cargoquery.map { it.title }
}

suspend fun main() {
    val lol = WikiUrls.httpClient.get<Adventurer.NestedTitle.Cargo> {
        url {
            host = WikiUrls.host
            protocol = WikiUrls.protocol
            path(WikiUrls.apiPath)
            parameters.appendAll(WikiUrls.baseParameters)
            parameters.append("tables", "Adventurers")
            parameters.append( "fields", Adventurer.members.joinToString(","))
            parameters.append("where", WikiUrls.buildWhereClause("Name", "E"))
        }

    }.cargoquery.map { it.title }
    println()
}


