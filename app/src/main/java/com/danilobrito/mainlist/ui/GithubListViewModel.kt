package com.danilobrito.mainlist.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.danilobrito.mainlist.domain.entity.bo.SearchResultBO
import com.danilobrito.mainlist.domain.state.StarState
import com.danilobrito.mainlist.domain.state.StarState.StarLoadingState
import com.danilobrito.mainlist.domain.state.StarState.StarErrorState
import com.danilobrito.mainlist.domain.state.StarState.StarSuccessState
import com.danilobrito.mainlist.domain.usecase.StarUseCase
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class GithubListViewModel(
    private val starUseCase: StarUseCase
) : ViewModel() {

    val starLiveData get(): MutableLiveData<StarState> = _starLiveData
    private val _starLiveData: MutableLiveData<StarState> = MutableLiveData()

    fun fetchStars() {
        _starLiveData.postValue(StarLoadingState)

        viewModelScope.launch {
            starUseCase().collect { result ->
                when {
                    result.isSuccess -> {
                        (result.getOrNull() as? SearchResultBO)?.let { response ->
                            _starLiveData.postValue(
                                StarSuccessState(response.toSearchResultVO())
                            )
                        }
                    }

                    result.isFailure -> {
                        _starLiveData.postValue(result.exceptionOrNull()?.exception())
                    }
                }
            }
        }
    }

    private fun Throwable?.exception(): StarState {
        return StarErrorState
    }
}