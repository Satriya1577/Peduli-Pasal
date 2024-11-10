package com.example.pedulipasal.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import com.example.pedulipasal.R
import com.example.pedulipasal.data.api.NewsApiService
import com.example.pedulipasal.data.model.NewsItem
import com.example.pedulipasal.helper.Result
import com.google.gson.Gson
import retrofit2.HttpException

class Repository(
    private val newsApiService: NewsApiService
) {
    fun getNews(): LiveData<Result<List<NewsItem>>> = liveData {
        emit(Result.Loading)
        try {
            val listNews = ArrayList<NewsItem>()
            val client = newsApiService.getNews().articles
            client?.forEach {
                if (it != null) {
                    listNews.add(it)
                }
            }
            emit(Result.Success(listNews))
        } catch (e: HttpException) {
            emit(Result.Error(e.toString()))
        } catch (e: Exception) {
            emit(Result.Error(e.toString()))
        }
    }
t
    companion object {
        @Volatile
        private var instance: Repository? = null
        fun getInstance(
            newsApiService: NewsApiService
        ): Repository =
            instance ?: synchronized(this) {
                instance ?: Repository(
                   newsApiService
                )
            }.also { instance = it }
    }
}