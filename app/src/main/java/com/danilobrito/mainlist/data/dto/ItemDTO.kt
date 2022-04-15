package com.danilobrito.mainlist.data.dto

import com.danilobrito.mainlist.domain.entity.bo.ItemBO
import com.google.gson.annotations.SerializedName

data class ItemDTO(
    @SerializedName("id") val id: Int? = null,
    @SerializedName("full_name") val full_name: String? = null,
    @SerializedName("owner") val owner: OwnerDTO? = null,
    @SerializedName("description") val desc: String? = null,
    @SerializedName("html_url") val repoUrl: String? = null,
    @SerializedName("forks_count") val forks: Int? = null,
    @SerializedName("stargazers_count") val stars: Int? = null
) {
    fun toItemsBO() = ItemBO(
        id = id,
        full_name = full_name,
        owner = owner?.toOwnerBO(),
        desc = desc,
        repoUrl = repoUrl,
        forks = forks,
        stars = stars
    )
}
