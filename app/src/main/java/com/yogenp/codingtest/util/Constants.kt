package com.yogenp.codingtest.util

import com.yogenp.codingtest.R
import com.yogenp.codingtest.domain.model.CaseStudy
import com.yogenp.codingtest.network.responses.SectionsResponse

const val TAG = "AppDebugLogs"
const val DEFAULT_PLACEHOLDER_IMAGE = R.drawable.default_image

val TEST_CASE_STUDY = CaseStudy(
    teaser = "Hello World!",
    title = "Hello Title World!",
    heroImage = "https://raw.githubusercontent.com/theappbusiness/engineering-challenge/main/endpoints/v1/images/decelerator_header-image-2x.jpg",
    sections = mutableListOf(
        SectionsResponse(
            title = "Reimagining brake testing",
            bodyElements = mutableListOf(
                "Hello1",
                "Hello2",
                "{image_url:https://raw.githubusercontent.com/theappbusiness/engineering-challenge/main/endpoints/v1/images/decelerator_pitch-roll-2x.jpg}"
            )
        )
    )
)