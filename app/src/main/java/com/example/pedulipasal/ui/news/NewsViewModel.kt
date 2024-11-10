package com.example.pedulipasal.ui.news

import androidx.lifecycle.ViewModel
import com.example.pedulipasal.data.NewsRepository

class NewsViewModel(private val newsRepository: NewsRepository) : ViewModel() {
    fun getNews() = newsRepository.getNews()
}