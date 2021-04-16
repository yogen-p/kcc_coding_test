package com.yogenp.codingtest.repository

import com.yogenp.codingtest.domain.model.CaseStudy
import com.yogenp.codingtest.network.CaseStudyNetworkService
import com.yogenp.codingtest.network.model.CaseStudyDTOMapper

class CaseStudyRepositoryImpl(
    private val networkService: CaseStudyNetworkService,
    private val mapper: CaseStudyDTOMapper
) : CaseStudyRepository{
    override suspend fun get(): List<CaseStudy> {
        return mapper.toDomainList(
            networkService.getFile().caseStudies
        )
    }
}