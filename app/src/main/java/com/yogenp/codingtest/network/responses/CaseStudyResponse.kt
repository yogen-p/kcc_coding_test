package com.yogenp.codingtest.network.responses

import com.google.gson.annotations.SerializedName
import com.yogenp.codingtest.network.model.CaseStudyDTO

data class CaseStudyResponse(

    @SerializedName("case_studies")
    var caseStudies: List<CaseStudyDTO>

)
