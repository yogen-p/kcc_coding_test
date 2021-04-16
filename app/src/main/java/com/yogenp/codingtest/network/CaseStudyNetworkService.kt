package com.yogenp.codingtest.network

import com.yogenp.codingtest.network.responses.CaseStudyResponse
import retrofit2.http.GET

interface CaseStudyNetworkService {

    @GET("caseStudies.json")
    suspend fun getFile(): CaseStudyResponse
}