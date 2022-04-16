package com.danilobrito.mainlist.data.dto

import com.google.gson.annotations.SerializedName

data class SearchResultDTO(
    @SerializedName("total_count") val total_count: Int? = null,
    @SerializedName("incomplete_results") val incomplete_results: Boolean = false,
    @SerializedName("items") val items: ArrayList<ItemDTO>? = null
)
