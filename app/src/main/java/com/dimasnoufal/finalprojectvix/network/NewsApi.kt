package com.dimasnoufal.finalprojectvix.network

import com.dimasnoufal.finalprojectvix.model.NewsEverythingResponse
import com.dimasnoufal.finalprojectvix.model.NewsTopResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsApi {
    @GET("top-headlines")
    fun getTopHeadlineNews(
        @Query("country") country: String?,
        @Query("apiKey") apiKey: String?
    ): Call<NewsTopResponse>

    @GET("everything")
    fun getEverythingNews(
        @Query("q") q: String?,
        @Query("apiKey") apiKey: String?
    ): Call<NewsEverythingResponse>
}