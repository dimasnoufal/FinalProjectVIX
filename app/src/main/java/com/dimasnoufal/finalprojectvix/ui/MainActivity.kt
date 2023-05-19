package com.dimasnoufal.finalprojectvix.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.dimasnoufal.finalprojectvix.R
import com.dimasnoufal.finalprojectvix.adapter.EverythingNewsAdapter
import com.dimasnoufal.finalprojectvix.adapter.TopHeadlineNewsAdapter
import com.dimasnoufal.finalprojectvix.databinding.ActivityMainBinding
import com.dimasnoufal.finalprojectvix.ui.viewmodels.MainViewModels
import com.dimasnoufal.finalprojectvix.utils.AppConstant

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    private val mainViewModels: MainViewModels by viewModels()
    private val topHeadlineNewsAdapter by lazy { TopHeadlineNewsAdapter() }
    private val everythingNewsAdapter by lazy { EverythingNewsAdapter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupListenerTopNews()
        setupListenerEveryNews()
        observTopNews()
        observeEveryNews()
    }

    private fun observeEveryNews() {
        mainViewModels.newsEverythingObserver.observe(this@MainActivity) { response ->
            if (response.status == "ok") {
                binding.rvEverythingNews.apply {
                    adapter = everythingNewsAdapter
                    setHasFixedSize(true)
                    layoutManager = LinearLayoutManager(
                        this@MainActivity,
                        LinearLayoutManager.VERTICAL,
                        false
                    )
                    everythingNewsAdapter.setData(response.articles)
                }
            }
            else Toast.makeText(this@MainActivity, "Data Tidak Ditemukan", Toast.LENGTH_SHORT).show()
        }
    }

    private fun observTopNews() {
        mainViewModels.newsTopObserver.observe(this@MainActivity) { response ->
            if (response.status == "ok") {
                binding.rvTopHeadlineNews.apply {
                    adapter = topHeadlineNewsAdapter
                    setHasFixedSize(true)
                    layoutManager = LinearLayoutManager(
                        this@MainActivity,
                        LinearLayoutManager.HORIZONTAL,
                        false
                    )
                    topHeadlineNewsAdapter.setData(response.articles)
                }
            }
            else Toast.makeText(this@MainActivity, "Data Tidak Ditemukan", Toast.LENGTH_SHORT).show()
        }
    }

    private fun setupListenerEveryNews() {
        mainViewModels.requestEverythingNews(
            AppConstant.Q,
            AppConstant.API_KEY
        )
        mainViewModels.status.observe(this@MainActivity, Observer { status ->
            mainViewModels.status.value = null
            Toast.makeText(this@MainActivity, "Response Gagal", Toast.LENGTH_SHORT).show()
        })
    }

    private fun setupListenerTopNews() {
        mainViewModels.requestTopHeadlineNews(
            AppConstant.COUNTRY,
            AppConstant.API_KEY
        )
        mainViewModels.status.observe(this@MainActivity, Observer { status ->
            mainViewModels.status.value = null
            Toast.makeText(this@MainActivity, "Response Gagal", Toast.LENGTH_SHORT).show()
        })
    }
}