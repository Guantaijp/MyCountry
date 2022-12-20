package com.example.mycountry.di

import com.example.mycountry.Utils.Constants.Companion.BASE_URL
import com.example.mycountry.data.CountryApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RetrofitModule {

    @Singleton
    @Provides
    fun provideRetrofit(): Retrofit {

        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    }

    @Singleton
    @Provides
    fun provideCountryApi(retrofit: Retrofit): CountryApi {
        return retrofit.create(CountryApi::class.java)

    }
}

