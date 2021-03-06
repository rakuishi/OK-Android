package com.rakuishi.ok.presentation.repo

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.rakuishi.ok.data.Repo
import com.rakuishi.ok.presentation.common.TwoLineViewHolder

class RepoAdapter : ListAdapter<Repo, RecyclerView.ViewHolder>(RepoDiffCallback()) {

    var onItemClick: ((Repo) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return TwoLineViewHolder(parent)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as TwoLineViewHolder).bind(getItem(position)) {
            onItemClick?.invoke(it)
        }
    }
}

private class RepoDiffCallback : DiffUtil.ItemCallback<Repo>() {
    override fun areItemsTheSame(oldItem: Repo, newItem: Repo): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Repo, newItem: Repo): Boolean {
        return oldItem == newItem
    }
}