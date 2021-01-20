package com.aibles.testgapoapi.presentation.viewmodel

import androidx.lifecycle.MutableLiveData
import com.aibles.testgapoapi.data.repository.NewsfeedRepositoryImpl
import com.aibles.testgapoapi.domain.entity.DetailNews

class DetailViewModel: BaseViewModel() {
    val detailNews = MutableLiveData<DetailNews>()

    fun fechDetailNews() {
        NewsfeedRepositoryImpl.getInstance().getDetailNews { isSuccess, response ->
            if (isSuccess) {
                detailNews.value = response
            }
        }
    }
}