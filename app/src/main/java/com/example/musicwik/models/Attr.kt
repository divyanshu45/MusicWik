package com.example.musicwik.models

import com.google.gson.annotations.SerializedName

data class Attr(
    @SerializedName("num_res")
    val numRes: Int,
    val offset: Int,
    val total: Int
)