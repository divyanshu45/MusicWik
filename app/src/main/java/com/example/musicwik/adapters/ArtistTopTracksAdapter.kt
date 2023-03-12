package com.example.musicwik.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.musicwik.databinding.ArtistInfoTopItemBinding
import com.example.musicwik.models.TrackXX
import com.example.musicwik.views.loadImage

class ArtistTopTracksAdapter : RecyclerView.Adapter<ArtistTopTracksAdapter.AristTopTracksViewHolder>() {
    inner class AristTopTracksViewHolder(val binding: ArtistInfoTopItemBinding) : RecyclerView.ViewHolder(binding.root)

    var artistInfoTopTracks : List<TrackXX> = emptyList()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AristTopTracksViewHolder {
        return AristTopTracksViewHolder(
            ArtistInfoTopItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            ))
    }

    override fun onBindViewHolder(holder: AristTopTracksViewHolder, position: Int) {
        holder.binding.apply {
            itemTitle.text = artistInfoTopTracks[position].name
            itemArtistName.text = artistInfoTopTracks[position].artist.name
            itemImg.loadImage(artistInfoTopTracks[position].image[2].text)
        }
    }

    override fun getItemCount(): Int {
        return artistInfoTopTracks.size
    }
}
