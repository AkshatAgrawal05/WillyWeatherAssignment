package com.willyweather.assignment.ui.home

import androidx.lifecycle.ViewModel
import com.willyweather.assignment.data.repository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val repository: Repository
) : ViewModel() {
    val teams = repository.getTeamsList(2018)
}