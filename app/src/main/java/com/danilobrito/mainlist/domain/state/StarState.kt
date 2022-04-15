package com.danilobrito.mainlist.domain.state

import com.danilobrito.mainlist.domain.entity.vo.SearchResultVO

sealed class StarState {

    data class StarSuccessState(val searchResultVO: SearchResultVO) : StarState()

    object StarLoadingState : StarState()

    object StarErrorState : StarState()
}
