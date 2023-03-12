package com.example.musicwik.models

import com.google.gson.annotations.SerializedName

data class Streamable(
    val fulltrack: String,
    @SerializedName("#text")
    val text: String
)