package com.yogenp.codingtest.repository

import com.yogenp.codingtest.domain.model.CaseStudy

interface CaseStudyRepository {

    suspend fun get(): List<CaseStudy>

}