package com.dimasnoufal.finalprojectvix.repository

import com.dimasnoufal.finalprojectvix.model.NewsEverythingResponse
import com.dimasnoufal.finalprojectvix.model.NewsTopResponse
import retrofit2.Call

interface NewsRepository {
    fun requestTopHeadlineNews(
        country: String?,
        apiKey: String?
    ): Call<NewsTopResponse>

    fun requestEverythingNews(
        q: String?,
        apiKey: String?
    ): Call<NewsEverythingResponse>
}