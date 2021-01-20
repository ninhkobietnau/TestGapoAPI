package com.aibles.testgapoapi.presentation.viewmodel

import androidx.lifecycle.MutableLiveData
import com.aibles.testgapoapi.data.repository.NewsfeedRepositoryImpl
import com.aibles.testgapoapi.domain.entity.ListNewsfeed.Newsfeed

class NewsfeedViewModel: BaseViewModel() {
    val newsfeed = MutableLiveData<List<Newsfeed>>()

    fun fetchNewsfeedList() {
        dataLoading.value = true
        NewsfeedRepositoryImpl.getInstance().getNewsfeed { isSuccess, response ->
            dataLoading.value = false
            if (isSuccess) {
                newsfeed.value = response?.items
                empty.value = false
            } else {
                empty.value = true
            }
        }
    }
}