package com.dimasnoufal.finalprojectvix.ui.viewmodels

import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.dimasnoufal.finalprojectvix.model.NewsEverythingResponse
import com.dimasnoufal.finalprojectvix.model.NewsTopResponse
import com.dimasnoufal.finalprojectvix.repository.NewsRepositoryImpl
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainViewModels: ViewModel() {
    val repository = NewsRepositoryImpl()

    var status = MutableLiveData<Boolean?>()

    val newsTopObserver: MutableLiveData<NewsTopResponse> = MutableLiveData()
    val newsEverythingObserver: MutableLiveData<NewsEverythingResponse> = MutableLiveData()

    fun requestTopHeadlineNews(
        country: String?,
        apiKey: String?
    ): LiveData<NewsTopResponse> {
        repository.requestTopHeadlineNews(country, apiKey).enqueue(object : Callback<NewsTopResponse> {
            override fun onResponse(
                call: Call<NewsTopResponse>,
                response: Response<NewsTopResponse>
            ) {
                if (response.isSuccessful) newsTopObserver.value = response.body()
                else status.value = true
            }

            override fun onFailure(call: Call<NewsTopResponse>, t: Throwable) {
                t.printStackTrace()
            }

        })
        return newsTopObserver
    }

    fun requestEverythingNews(
        q: String?,
        apiKey: String?
    ): LiveData<NewsEverythingResponse> {
        repository.requestEverythingNews(q, apiKey).enqueue(object : Callback<NewsEverythingResponse> {
            override fun onResponse(
                call: Call<NewsEverythingResponse>,
                response: Response<NewsEverythingResponse>
            ) {
                if (response.isSuccessful) newsEverythingObserver.value = response.body()
                else status.value = true
            }

            override fun onFailure(call: Call<NewsEverythingResponse>, t: Throwable) {
                t.printStackTrace()
            }

        })
        return newsEverythingObserver
    }
}