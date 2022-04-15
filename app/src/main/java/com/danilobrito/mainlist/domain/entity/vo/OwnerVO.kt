package com.danilobrito.mainlist.domain.entity.vo

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class OwnerVO(
    var user: String?,
    var avatar_url: String?,
    var type: String?
) : Parcelable
