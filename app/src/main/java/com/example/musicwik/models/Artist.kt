package com.example.musicwik.models

import com.google.gson.annotations.SerializedName

data class Artist(
    val mbid: String,
    val name: String,
    val url: String
)