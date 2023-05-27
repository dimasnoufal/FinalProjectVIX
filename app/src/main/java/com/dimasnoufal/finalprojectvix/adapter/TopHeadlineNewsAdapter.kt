package com.dimasnoufal.finalprojectvix.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.dimasnoufal.finalprojectvix.R
import com.dimasnoufal.finalprojectvix.databinding.ItemRowTopHeadlineNewsBinding
import com.dimasnoufal.finalprojectvix.model.NewsTopResponse

class TopHeadlineNewsAdapter :
    RecyclerView.Adapter<TopHeadlineNewsAdapter.TopHeadlineNewsViewHolder>() {

    private var newsTop: List<NewsTopResponse.ArticlesItem?>? = listOf()

    inner class TopHeadlineNewsViewHolder(private val binding: ItemRowTopHeadlineNewsBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(data: NewsTopResponse.ArticlesItem) {
            binding.apply {
                Glide.with(ivPosterTop)
                    .load(data.urlToImage)
                    .error(R.drawable.ic_launcher_background)
                    .into(ivPosterTop)
                tvTittleTop.text = data.title
                tvSourceTop.text = data.source!!.name
                tvDateTop.text = data.publishedAt
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TopHeadlineNewsViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val rowBinding = ItemRowTopHeadlineNewsBinding.inflate(layoutInflater, parent, false)
        return TopHeadlineNewsViewHolder(rowBinding)
    }

    override fun getItemCount(): Int {
//        return newsTop!!.size
        return 3
    }

    override fun onBindViewHolder(holder: TopHeadlineNewsViewHolder, position: Int) {
        holder.bind(newsTop!![position]!!)
    }

    fun setData(data: List<NewsTopResponse.ArticlesItem?>?) {
        newsTop = data
    }
}