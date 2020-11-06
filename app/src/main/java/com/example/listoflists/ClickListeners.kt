package com.example.listoflists

class CarOnClickListener(val clickListener: (car: Car) -> Unit) {
    fun onClick(car: Car) = clickListener(car)
}

class PieceOnClickListener(val clickListener: (piece: Piece) -> Unit) {
    fun onClick(piece: Piece) = clickListener(piece)
}