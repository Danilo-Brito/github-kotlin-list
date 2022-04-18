package com.danilobrito.mainlist.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.danilobrito.mainlist.data.dto.ItemDTO
import com.danilobrito.mainlist.databinding.ItemGitBinding
import com.danilobrito.mainlist.ui.mainlist.GithubListActivity

class GithubAdapter(context: Context) : PagingDataAdapter<ItemDTO, GithubAdapter.GitRepoViewHolder>(DIFF_UTILL) {

    companion object {
        val DIFF_UTILL = object  : DiffUtil.ItemCallback<ItemDTO>(){
            override fun areItemsTheSame(oldItem: ItemDTO, newItem: ItemDTO): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: ItemDTO, newItem: ItemDTO): Boolean {
                return oldItem == newItem
            }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GitRepoViewHolder {
        val bind = ItemGitBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return GitRepoViewHolder(bind)
    }

    override fun onBindViewHolder(holder: GitRepoViewHolder, position: Int) {
        val repo = getItem(position)
        Glide.with(holder.bind.image.context).asBitmap()
            .load(repo?.owner?.avatar_url)
            .into(holder.bind.image)
        holder.bind.name.text = repo?.name
        holder.bind.tvForks.text = repo?.forks.toString()
        holder.bind.tvStars.text = repo?.stars.toString()
        holder.bind.autor.text = repo?.owner?.user

    }

    inner class GitRepoViewHolder(val bind: ItemGitBinding) : RecyclerView.ViewHolder(bind.root)

}