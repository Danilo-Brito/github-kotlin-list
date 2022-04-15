package com.danilobrito.mainlist.domain.entity.bo

import com.danilobrito.mainlist.domain.entity.vo.OwnerVO

data class OwnerBO(
    var user: String?,
    var avatar_url: String?,
    var type: String?
) {
    fun toOwnerVO() = OwnerVO(
        user = user,
        avatar_url = avatar_url,
        type = type
    )
}