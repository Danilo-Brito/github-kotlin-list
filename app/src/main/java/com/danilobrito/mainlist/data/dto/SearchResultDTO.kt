package com.danilobrito.mainlist.data.dto

import com.danilobrito.mainlist.domain.entity.bo.SearchResultBO
import com.google.gson.annotations.SerializedName

data class SearchResultDTO(
    @SerializedName("total_count") val total_count: Int? = null,
    @SerializedName("incomplete_results") val incomplete_results: Boolean = false,
    @SerializedName("items") val items: List<ItemDTO>? = null
) {
    fun toSearchResultBO() = SearchResultBO(
        total_count = total_count,
        incomplete_results = incomplete_results,
        items = items?.map { it.toItemsBO() }
    )
}
