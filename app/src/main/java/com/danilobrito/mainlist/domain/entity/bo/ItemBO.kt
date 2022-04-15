package com.danilobrito.mainlist.domain.entity.bo

import com.danilobrito.mainlist.domain.entity.vo.ItemVO

data class ItemBO(
    var id: Int?,
    var full_name: String?,
    var owner: OwnerBO?,
    var desc: String?,
    var repoUrl: String?,
    var forks: Int?,
    var stars: Int?
) {
    fun toItemsVO() = ItemVO(
        id = id,
        full_name = full_name,
        owner = owner?.toOwnerVO(),
        desc = desc,
        repoUrl = repoUrl,
        forks = forks,
        stars = stars
    )
}