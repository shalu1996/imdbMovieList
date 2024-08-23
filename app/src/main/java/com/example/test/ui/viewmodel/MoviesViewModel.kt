package com.example.test.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.test.ViewState
import com.example.test.data.model.Movie
import com.example.test.domain.usecase.MoviesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MoviesViewModel @Inject constructor(
    private val useCase: MoviesUseCase
) : ViewModel() {

    private var _mutableMoviesLiveData = MutableLiveData<ViewState<List<Movie>>>()
    val liveData = _mutableMoviesLiveData

    fun getMovies() {
        viewModelScope.launch {
            _mutableMoviesLiveData.value = ViewState.LOADING()
            try {
                val list = useCase.getMovies()
                _mutableMoviesLiveData.value = list
            } catch (e: Exception) {
                _mutableMoviesLiveData.value = ViewState.ERROR(e.toString())
            }
        }
    }
}