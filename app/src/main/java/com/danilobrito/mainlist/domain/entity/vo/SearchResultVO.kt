package com.danilobrito.mainlist.domain.entity.vo

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class SearchResultVO(
    var total_count: Int?,
    var incomplete_results: Boolean = false,
    var items: List<ItemVO>?
) : Parcelable
