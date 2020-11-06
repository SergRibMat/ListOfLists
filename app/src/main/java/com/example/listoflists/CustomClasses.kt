package com.example.listoflists

data class Car(
    val id: Int,
    val name: String,
    var pieces: List<Piece> = listOf()
)

data class Piece(
    val id: Int,
    val name: String,
)