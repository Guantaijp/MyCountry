package com.example.mycountry.UI

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope


//import com.example.mycountry.domain.GetGamesUseCase
//import com.example.mycountry.domain.item.CountryItem
import com.example.mycountry.repo.CountryRepository
import com.welovecrazyquotes.countrylistapp.model.Country
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(

    private val countryRepository: CountryRepository,

) : ViewModel() {

    private val _games = MutableStateFlow(emptyList<Country>())
    val games : StateFlow<List<Country>>
        get() = _games


    init {
        getCountries()
    }

    private fun getCountries() {
        viewModelScope.launch {
            try {
                val countries = countryRepository.getCountries()
                _games.value = countries

            } catch (_: Exception) {}
        }
    }
}