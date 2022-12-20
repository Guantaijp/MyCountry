package com.example.mycountry.repo

import com.example.mycountry.data.CountryService
import com.welovecrazyquotes.countrylistapp.model.Country
//import com.example.mycountry.data.model.CountryModel


import javax.inject.Inject

class CountryRepository @Inject constructor(private val countryService: CountryService) {

    suspend fun getCountries() : List<Country> {
      return countryService.getCountries()
    }

}
