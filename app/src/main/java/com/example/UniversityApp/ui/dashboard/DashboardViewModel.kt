package com.example.UniversityApp.ui.dashboard

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.UniversityApp.data.model.DashboardResponse
import com.example.UniversityApp.data.repository.AuthRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DashboardViewModel @Inject constructor(
    private val repository: AuthRepository
) : ViewModel() {
    annotation class AuthRepository

    private val _dashboardResult = MutableLiveData<Result<DashboardResponse>>()
    val dashboardResult: LiveData<Result<DashboardResponse>> = _dashboardResult

    annotation class DashboardResponse

    fun loadDashboard(keypass: String) {
        viewModelScope.launch {
            _dashboardResult.value = repository.getDashboard(keypass)
        }
    }

    private fun DashboardViewModel.AuthRepository.getDashboard(
        string: kotlin.String
    ) {
    }
}