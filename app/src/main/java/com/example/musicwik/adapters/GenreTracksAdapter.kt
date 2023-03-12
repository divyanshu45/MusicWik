package com.example.musicwik.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.musicwik.databinding.CardItemBinding
import com.example.musicwik.models.Track
import com.example.musicwik.views.loadImage

class GenreTracksAdapter : RecyclerView.Adapter<GenreTracksAdapter.GenreTracksViewHolder>() {
    inner class GenreTracksViewHolder(val binding: CardItemBinding) : RecyclerView.ViewHolder(binding.root)
    var genreTracks : List<Track> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GenreTracksViewHolder {
        return GenreTracksViewHolder(
            CardItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        ))
    }

    override fun onBindViewHolder(holder: GenreTracksViewHolder, position: Int) {



        holder.binding.apply {
            itemTitle.text = genreTracks[position].name
            itemArtistName.text = genreTracks[position].artist.name
            itemImg.loadImage(genreTracks[position].image[2].text)
        }
    }

    override fun getItemCount(): Int {
        return genreTracks.size
    }
}