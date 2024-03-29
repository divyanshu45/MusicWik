package com.example.musicwik.models

import com.google.gson.annotations.SerializedName

data class Link(
    val href: String,
    val rel: String,
    @SerializedName("#text")
    val text: String
)