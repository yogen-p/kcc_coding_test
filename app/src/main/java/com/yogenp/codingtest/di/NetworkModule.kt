package com.yogenp.codingtest.di

import com.google.gson.GsonBuilder
import com.yogenp.codingtest.network.CaseStudyNetworkService
import com.yogenp.codingtest.network.model.CaseStudyDTOMapper
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Singleton
    @Provides
    fun provideCSMapper(): CaseStudyDTOMapper {
        return CaseStudyDTOMapper()
    }

    @Singleton
    @Provides
    fun provideCSNetworkService(): CaseStudyNetworkService {
        return Retrofit.Builder()
            .baseUrl("https://raw.githubusercontent.com/theappbusiness/engineering-challenge/main/endpoints/v1/")
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
            .build()
            .create(CaseStudyNetworkService::class.java)
    }
}