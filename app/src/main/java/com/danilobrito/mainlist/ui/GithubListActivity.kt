package com.danilobrito.mainlist.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.danilobrito.mainlist.R
import org.koin.androidx.viewmodel.ext.android.viewModel
import com.danilobrito.mainlist.domain.state.StarState.StarLoadingState
import com.danilobrito.mainlist.domain.state.StarState.StarErrorState
import com.danilobrito.mainlist.domain.state.StarState.StarSuccessState

class GithubListActivity : AppCompatActivity() {

    private val viewModel: GithubListViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_github_list)
        observeStars()

        callViewModel()
    }

    private fun callViewModel(){
        viewModel.fetchStars()
    }

    private fun observeStars() {
        viewModel.starLiveData.observe(this) {
            when (it) {
                is StarSuccessState -> {
                    Log.i("GithubList", "observeStars: OK")
                }
                is StarLoadingState -> {
                    Log.i("GithubList", "observeStars: Loading")
                }
                is StarErrorState -> {
                    Log.i("GithubList", "observeStars: Error")
                }
            }
        }
    }
}