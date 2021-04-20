package com.example.weather.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.weather.core.ViewState
import com.example.weather.data.TempItem
import com.example.weather.domain.MainRepository
import kotlinx.coroutines.launch

class MainViewModel(private val repository: MainRepository) : ViewModel() {

    private var temperature = MutableLiveData<List<TempItem>>()

    val viewState = MutableLiveData<ViewState>()

    fun getWeekTemp() : LiveData<List<TempItem>> {
        viewModelScope.launch{
            try {
                viewState.postValue(ViewState.Loading)
                repository.getWeekTemp(
                        onSuccess = {
                            temperature.postValue(it)
                            viewState.postValue(ViewState.Success)
                                    },
                        onFail = { viewState.postValue(ViewState.Error(message = "Internet error connection")) })
            } catch (e: Exception){
                viewState.postValue(ViewState.Error(message = e.message))
            }
        }
        return temperature
    }
}