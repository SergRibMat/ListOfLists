package com.example.listoflists

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView

@BindingAdapter("carList")//listData will be transformed into the name property that this will have
fun bindRecyclerView(recyclerView: RecyclerView, data: List<Car>?) {
    val adapter = recyclerView.adapter as CarAdapter
    adapter.submitList(data)
}

@BindingAdapter("pieceList")//listData will be transformed into the name property that this will have
fun bindRecyclerViewPiece(recyclerView: RecyclerView, data: List<Piece>?) {
    val adapter = recyclerView.adapter as PieceAdapter
    adapter.submitList(data)
}