package com.example.musicwik.models


import com.google.gson.annotations.SerializedName

data class AlbumXX(
    val artist: ArtistXXXXXXX,
    val image: List<ImageXXXXXX>,
    val mbid: String,
    val name: String,
    val playcount: Int,
    val url: String
)