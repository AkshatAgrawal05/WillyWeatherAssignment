package com.willyweather.assignment.ui.details

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.switchMap
import com.willyweather.assignment.data.model.TeamsItem
import com.willyweather.assignment.data.repository.Repository
import com.willyweather.assignment.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DetailsViewModel @Inject constructor(private val repository: Repository) : ViewModel() {

    private val _id = MutableLiveData<Int>()

    fun fetchDetails(teamId: Int) {
        _id.value = teamId
    }

    private val _teamDetail = _id.switchMap { id ->
        repository.getTeamDetails(id)
    }
    val teamDetails: LiveData<Resource<TeamsItem>> = _teamDetail


}