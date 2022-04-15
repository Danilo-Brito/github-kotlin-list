package com.danilobrito.mainlist.domain.entity.vo

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ItemVO(
    var id: Int?,
    var full_name: String?,
    var owner: OwnerVO?,
    var desc: String?,
    var repoUrl: String?,
    var forks: Int?,
    var stars: Int?
) : Parcelable
