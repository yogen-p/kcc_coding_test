package com.yogenp.codingtest.network.model

import com.google.gson.annotations.SerializedName
import com.yogenp.codingtest.network.responses.SectionsResponse

//  Network Model
data class CaseStudyDTO(
    @SerializedName("id")
    var id: Int? = null,

    @SerializedName("client")
    var client: String? = null,

    @SerializedName("teaser")
    var teaser: String? = null,

    @SerializedName("vertical")
    var vertical: String? = null,

    @SerializedName("is_enterprise")
    var isEnterprise: Boolean? = null,

    @SerializedName("title")
    var title: String? = null,

    @SerializedName("hero_image")
    var heroImage: String? = null,

    @SerializedName("app_store_url")
    var appStoreUrl: String? = null,

    @SerializedName("sections")
    var sections: MutableList<SectionsResponse>? = null

)