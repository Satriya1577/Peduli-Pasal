package com.example.pedulipasal.ui.news

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.pedulipasal.data.Repository

class NewsViewModel(private val repository: Repository) : ViewModel() {
    fun getNews() = repository.getNews()
}