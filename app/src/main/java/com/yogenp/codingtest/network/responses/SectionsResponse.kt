package com.yogenp.codingtest.network.responses

import com.google.gson.annotations.SerializedName

data class SectionsResponse(

    @SerializedName("title")
    var title: String,

    @SerializedName("body_elements")
    var bodyElements: MutableList<Any>

)
