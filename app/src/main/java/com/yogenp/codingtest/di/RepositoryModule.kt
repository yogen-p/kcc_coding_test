package com.yogenp.codingtest.di

import com.yogenp.codingtest.network.CaseStudyNetworkService
import com.yogenp.codingtest.network.model.CaseStudyDTOMapper
import com.yogenp.codingtest.repository.CaseStudyRepository
import com.yogenp.codingtest.repository.CaseStudyRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Singleton
    @Provides
    fun provideCaseStudyRepository(
        networkService: CaseStudyNetworkService,
        mapper: CaseStudyDTOMapper
    ): CaseStudyRepository{
        return CaseStudyRepositoryImpl(networkService, mapper)
    }
}