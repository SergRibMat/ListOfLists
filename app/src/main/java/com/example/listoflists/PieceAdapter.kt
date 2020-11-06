package com.example.listoflists

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.listoflists.databinding.ItemPieceBinding

class PieceAdapter(val onClickClickListener: PieceOnClickListener): ListAdapter<Piece, PieceAdapter.PieceViewHolder>(DiffCallback) {

    companion object DiffCallback : DiffUtil.ItemCallback<Piece>() {
        override fun areItemsTheSame(oldItem: Piece, newItem: Piece): Boolean {
            //this methods runs first
            //compares if the objects are the same
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Piece, newItem: Piece): Boolean {
            return oldItem == newItem //compares if this property of the objects are the same
        }
    }

    class PieceViewHolder(private var binding: ItemPieceBinding):
        RecyclerView.ViewHolder(binding.root) {
        fun bind(piece: Piece, onClickClickListener: PieceOnClickListener) {
            binding.piece = piece
            binding.onClickClickListener = onClickClickListener
            binding.executePendingBindings()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PieceViewHolder {
        return PieceViewHolder(ItemPieceBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: PieceViewHolder, position: Int) {
        val piece = getItem(position)
        holder.bind(piece, onClickClickListener)
    }
}