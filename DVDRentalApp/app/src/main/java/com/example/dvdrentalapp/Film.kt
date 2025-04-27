package com.example.dvdrentalapp

data class Film(
    val id: Int,
    val title: String,
    val director: String,
    val year: Int,
    val synopsis: String,
    val productionHouse: String,
    val posterResId: Int
)