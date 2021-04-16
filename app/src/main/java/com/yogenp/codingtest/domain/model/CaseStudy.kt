package com.yogenp.codingtest.domain.model

import com.yogenp.codingtest.network.responses.SectionsResponse

data class CaseStudy(

    var id: Int? = null,
    var client: String? = null,
    var teaser: String? = null,
    var vertical: String? = null,
    var isEnterprise: Boolean? = null,
    var title: String? = null,
    var heroImage: String? = null,
    var appStoreUrl: String? = null,
    var sections: MutableList<SectionsResponse>? = null
)
