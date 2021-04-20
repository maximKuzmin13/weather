package com.example.weather.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.weather.core.ViewState
import com.example.weather.data.TempItem
import com.example.weather.domain.Interactor
import kotlinx.coroutines.launch

class MainViewModel(private val interactor: Interactor) : ViewModel() {

    var temperature = MutableLiveData<List<TempItem>>()

    val viewState = MutableLiveData<ViewState>()

    fun getWeekTemp() : LiveData<List<TempItem>> {
        viewModelScope.launch{
            viewState.postValue(ViewState.Loading)

            interactor.getWeekTemp(
                    onSuccess = {
                        temperature.postValue(it)

                        viewState.postValue(ViewState.Success)
                    },
                    onFail = { viewState.postValue(ViewState.Error(message = it?.message)) })
            temperature.value?.let { interactor.insert(it) }
        }
        return temperature
    }
}