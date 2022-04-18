package com.danilobrito.mainlist.ui.mainlist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.danilobrito.mainlist.databinding.ActivityGithubListBinding
import org.koin.androidx.viewmodel.ext.android.viewModel
import com.danilobrito.mainlist.ui.adapter.GithubAdapter
import com.danilobrito.mainlist.ui.adapter.LoadingAdapter
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class GithubListActivity : AppCompatActivity() {

    private val viewModel: GithubListViewModel by viewModel()
    private val mAdapter by lazy { GithubAdapter(this) }
    private lateinit var bind: ActivityGithubListBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bind = ActivityGithubListBinding.inflate(layoutInflater)
        setContentView(bind.root)
        setupRecyclerView()
        loadData()
    }

    private fun setupRecyclerView() {
        bind.rvGitRepo.apply {
            layoutManager = LinearLayoutManager(this@GithubListActivity)
            adapter = mAdapter.withLoadStateHeaderAndFooter(
                header = LoadingAdapter(mAdapter),
                footer = LoadingAdapter(mAdapter)
            )
            addItemDecoration(
                DividerItemDecoration(
                    applicationContext,
                    DividerItemDecoration.VERTICAL
                )
            )
        }
    }

    private fun loadData() {
        showProgress()
        viewModel.fetchRepository(LANGUAGE)

        lifecycleScope.launch{
            viewModel.githubFlow.collect {
                mAdapter.submitData(
                    it
                )
            }
        }
    }

    private fun showProgress() {

    }

    companion object {
        private val LANGUAGE: String = "language:kotlin"
    }
}