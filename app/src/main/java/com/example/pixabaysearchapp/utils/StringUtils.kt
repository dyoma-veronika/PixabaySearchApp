package com.example.pixabaysearchapp.utils

fun String.getAsList(): List<String> {
    val items = this.split(",").map {
        it.replace(" ", "").trim()
    }
    return items
}
