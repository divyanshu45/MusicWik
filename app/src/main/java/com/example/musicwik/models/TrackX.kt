package com.example.musicwik.models

import com.google.gson.annotations.SerializedName

data class TrackX(
    val artist: ArtistXXX,
    @SerializedName("@attr")
    val attr: AttrXXXXXXX,
    val duration: Int,
    val name: String,
    val streamable: StreamableX,
    val url: String
)