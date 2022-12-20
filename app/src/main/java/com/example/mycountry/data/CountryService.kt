package com.example.mycountry.data

import javax.inject.Inject

class CountryService @Inject constructor(private val countryApi: CountryApi) {

    suspend fun getCountries() = countryApi.getCountries()

}
