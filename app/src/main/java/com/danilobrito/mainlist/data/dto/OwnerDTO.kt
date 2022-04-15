package com.danilobrito.mainlist.data.dto

import com.danilobrito.mainlist.domain.entity.bo.OwnerBO
import com.google.gson.annotations.SerializedName

data class OwnerDTO(
    @SerializedName("login") val user: String? = null,
    @SerializedName("avatar_url") val avatar_url: String? = null,
    @SerializedName("type") val type: String? = null
) {
    fun toOwnerBO() = OwnerBO(
        user = user,
        avatar_url = avatar_url,
        type = type
    )
}
