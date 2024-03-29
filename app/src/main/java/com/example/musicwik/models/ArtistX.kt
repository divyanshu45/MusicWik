package com.example.musicwik.models

import com.google.gson.annotations.SerializedName

data class ArtistX(
    @SerializedName("@attr")
    val attr: AttrXXX,
    val image: List<ImageX>,
    val mbid: String,
    val name: String,
    val streamable: String,
    val url: String
)