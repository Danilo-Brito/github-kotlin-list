package com.danilobrito.mainlist.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.LoadState
import androidx.paging.LoadStateAdapter
import androidx.recyclerview.widget.RecyclerView
import com.danilobrito.mainlist.R
import com.danilobrito.mainlist.databinding.LoadingBinding

class LoadingAdapter(
    private val githubAdapter: GithubAdapter
) : LoadStateAdapter<LoadingAdapter.LoadingAdapterViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        loadState: LoadState
    ): LoadingAdapterViewHolder = LoadingAdapterViewHolder(
        LoadingBinding.bind(
            LayoutInflater.from(parent.context).inflate(
                R.layout.loading, parent, false
            )
        )
    )


    override fun onBindViewHolder(holder: LoadingAdapterViewHolder, loadState: LoadState) =
        holder.bind(loadState)

    class LoadingAdapterViewHolder(
        private val bind: LoadingBinding
    ) : RecyclerView.ViewHolder(bind.root) {

        fun bind(load: LoadState) {}
    }
}