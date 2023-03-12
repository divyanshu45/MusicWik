package com.example.musicwik.models
import com.google.gson.annotations.SerializedName

data class TagX(
    val name: String,
    val reach: Int,
    val total: Int,
    val wiki: Wiki
)