package com.dimasnoufal.finalprojectvix.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.dimasnoufal.finalprojectvix.R
import com.dimasnoufal.finalprojectvix.databinding.ItemRowEverythingNewsBinding
import com.dimasnoufal.finalprojectvix.databinding.ItemRowTopHeadlineNewsBinding
import com.dimasnoufal.finalprojectvix.model.NewsEverythingResponse
import com.dimasnoufal.finalprojectvix.model.NewsTopResponse

class EverythingNewsAdapter() :
    RecyclerView.Adapter<EverythingNewsAdapter.EverythingNewsViewHolder>() {

    private var newsEvery: List<NewsEverythingResponse.ArticlesItem?>? = listOf()

    inner class EverythingNewsViewHolder(private val binding: ItemRowEverythingNewsBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(data: NewsEverythingResponse.ArticlesItem) {
            binding.apply {
                Glide.with(ivPosterEvery)
                    .load(data.urlToImage)
                    .error(R.drawable.ic_launcher_background)
                    .into(ivPosterEvery)
                tvTittleEvery.text = data.title
                tvAuthorEvery.text = data.author
                tvDateEvery.text = data.publishedAt
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EverythingNewsViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val rowBinding = ItemRowEverythingNewsBinding.inflate(layoutInflater, parent, false)
        return EverythingNewsViewHolder(rowBinding)
    }

    override fun getItemCount(): Int {
        return newsEvery!!.size
    }

    override fun onBindViewHolder(holder: EverythingNewsViewHolder, position: Int) {
        holder.bind(newsEvery!![position]!!)
    }

    fun setData(data: List<NewsEverythingResponse.ArticlesItem?>?) {
        newsEvery = data
    }
}