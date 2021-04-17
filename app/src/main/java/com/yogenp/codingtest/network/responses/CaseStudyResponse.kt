package com.yogenp.codingtest.network.responses

import com.google.gson.annotations.SerializedName
import com.yogenp.codingtest.network.model.CaseStudyDTO

// Base Response
data class CaseStudyResponse(

    @SerializedName("case_studies")
    var caseStudies: List<CaseStudyDTO>

)
