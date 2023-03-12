package com.example.musicwik.models

import com.google.gson.annotations.SerializedName

data class Tracks(
    @SerializedName("@attr")
    val attr: AttrXXXXX,
    val track: List<Track>
)