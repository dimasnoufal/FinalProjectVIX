package com.dimasnoufal.finalprojectvix.repository

import com.dimasnoufal.finalprojectvix.model.NewsEverythingResponse
import com.dimasnoufal.finalprojectvix.model.NewsTopResponse
import com.dimasnoufal.finalprojectvix.network.Service
import retrofit2.Call

class NewsRepositoryImpl: NewsRepository {
    override fun requestTopHeadlineNews(country: String?, apiKey: String?): Call<NewsTopResponse> {
        return Service.getApiService().getTopHeadlineNews(country, apiKey)
    }

    override fun requestEverythingNews(q: String?, apiKey: String?): Call<NewsEverythingResponse> {
        return Service.getApiService().getEverythingNews(q, apiKey)
    }
}