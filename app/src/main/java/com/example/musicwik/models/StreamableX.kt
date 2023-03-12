package com.example.musicwik.models
import com.google.gson.annotations.SerializedName

data class StreamableX(
    val fulltrack: String,
    @SerializedName("#text")
    val text: String
)