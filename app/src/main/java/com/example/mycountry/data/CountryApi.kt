package com.example.mycountry.data

import com.example.mycountry.Utils.Constants.Companion.COUNTRY_ENDPOINT


import com.welovecrazyquotes.countrylistapp.model.Country
import retrofit2.http.GET

interface CountryApi {
    @GET(
        COUNTRY_ENDPOINT
    )
    suspend fun getCountries(): List<Country>
}