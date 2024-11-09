package com.example.pedulipasal.di

import android.content.Context
import com.example.pedulipasal.data.Repository
import com.example.pedulipasal.data.api.ApiConfig

object Injection {
    fun provideRepository(context: Context): Repository {

        // val pref = UserPreference.getInstance(context.dataStore)
//        val apiService = ApiConfig.getApiService {
//            runBlocking { pref.getSession().first().token }
//        }

        val newsApiService = ApiConfig.getNewsApiService()
        return Repository.getInstance(newsApiService)
    }
}