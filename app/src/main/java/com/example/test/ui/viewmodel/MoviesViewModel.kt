package com.example.test.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.test.ViewState
import com.example.test.data.model.Movie
import com.example.test.domain.usecase.MoviesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MoviesViewModel @Inject constructor(
    private val useCase: MoviesUseCase
) : ViewModel() {

    private var _mutableMoviesLiveData =
        MutableStateFlow<ViewState<List<Movie>>>(ViewState.LOADING())
    val liveData = _mutableMoviesLiveData

    //first state whether the search is happening or not
    private val _isSearching = MutableStateFlow(true)
    val isSearching = _isSearching.asStateFlow()

    //second state the text typed by the user
    private val _searchText = MutableStateFlow("")
    val searchText = _searchText.asStateFlow()

    init {
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

    //third state the list to be filtered
    val countriesList = searchText
        .combine(_mutableMoviesLiveData) { text, movies ->//combine searchText with _contriesList
            if (text.isBlank()) { //return the entery list of countries if not is typed
                movies
            } else {
                ViewState.SUCCESS(_mutableMoviesLiveData.value.data?.filter { movie ->// filter and return a list of countries based on the text the user typed
                    movie.title.contains(text.trim(), ignoreCase = true)
                })
            }
        }.stateIn(//basically convert the Flow returned from combine operator to StateFlow
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5000),//it will allow the StateFlow survive 5 seconds before it been canceled
            initialValue = _mutableMoviesLiveData.value
        )

    fun onSearchTextChange(text: String) {
        _searchText.value = text
    }

    fun getMovieById(movieId: Int): Movie? =
        countriesList.value.data?.firstOrNull { it.id == movieId }

}