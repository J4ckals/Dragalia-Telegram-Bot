package com.dragaliabot.utils

import io.ktor.http.ParametersBuilder

fun ParametersBuilder.append(name: String, value: Any)
        = append(name, value.toString())