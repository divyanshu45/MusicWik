package com.example.musicwik.models
import com.google.gson.annotations.SerializedName

data class Topartists(
    val artist: List<ArtistX>,
    @SerializedName("@attr")
    val attr: AttrXXXX
)