package com.danilobrito.mainlist.data.paging

import android.util.Log
import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.danilobrito.mainlist.data.api.GithubAPI
import com.danilobrito.mainlist.data.dto.ItemDTO
import com.danilobrito.mainlist.util.ApiConstants.Companion.START_PAGE_INDEX
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class GithubDataSource(
    private val language: String,
    private val githubAPI: GithubAPI,
    private val dispatcherProvider: Dispatchers
) : PagingSource<Int, ItemDTO>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, ItemDTO> {
        val currentPage: Int = params.key ?: START_PAGE_INDEX
        return try {
            withContext(dispatcherProvider.IO) {

                val response =
                    githubAPI.getGithubRepository(queryParams = language, page = currentPage)

                val itens: ArrayList<ItemDTO>
                return@withContext try {
                    if (response.isSuccessful) {
                        itens = response.body()?.items!!
                    } else {
                        throw Exception(response.errorBody().toString())
                    }

                    LoadResult.Page(
                        data = itens,
                        prevKey = if(currentPage == START_PAGE_INDEX) null else currentPage -1,
                        nextKey = if (itens.isEmpty()) null else currentPage + 1

                    )
                } catch (e: Exception) {
                    LoadResult.Error(e)
                }
            }
        } catch (e: Exception) {
            Log.i("Paging Error", e.toString())
            return LoadResult.Error(e)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, ItemDTO>): Int? {
        return state.anchorPosition?.let {
            val anchorPage = state.closestPageToPosition(it)
            anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)
        }
    }

}