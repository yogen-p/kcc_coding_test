package com.yogenp.codingtest.repository

import com.yogenp.codingtest.domain.model.CaseStudy

/*
* Repository for remote data source
* */
interface CaseStudyRepository {

    suspend fun get(): List<CaseStudy>

}