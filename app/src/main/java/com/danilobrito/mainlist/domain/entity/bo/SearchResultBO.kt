package com.danilobrito.mainlist.domain.entity.bo

import com.danilobrito.mainlist.domain.entity.vo.SearchResultVO

data class SearchResultBO(
    var total_count: Int?,
    var incomplete_results: Boolean = false,
    var items: List<ItemBO>?
) {
    fun toSearchResultVO() = SearchResultVO(
        total_count = total_count,
        incomplete_results = incomplete_results,
        items = items?.map {it.toItemsVO()}
    )
}
