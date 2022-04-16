package com.danilobrito.mainlist.ui.mainlist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.danilobrito.mainlist.data.dto.ItemDTO
import com.danilobrito.mainlist.data.repository.GithubRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

class GithubListViewModel(
    private val repository: GithubRepository,
) : ViewModel() {

    private lateinit var _githubFlow: Flow<PagingData<ItemDTO>>
    val githubFlow: Flow<PagingData<ItemDTO>> get() = _githubFlow

    fun fetchRepository(string: String) = viewModelScope.launch {
        _githubFlow = repository.getGithubRepository(string).cachedIn(viewModelScope)
    }
}