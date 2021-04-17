package com.yogenp.codingtest.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.yogenp.codingtest.R
import com.yogenp.codingtest.domain.model.CaseStudy
import com.yogenp.codingtest.util.DEFAULT_PLACEHOLDER_IMAGE
import com.yogenp.codingtest.util.loadImage

@Composable
fun SectionView(
    caseStudy: CaseStudy
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        caseStudy.heroImage?.let { url ->
            val image = loadImage(
                url = url,
                defaultImage = DEFAULT_PLACEHOLDER_IMAGE
            ).value
            image?.let {
                Image(
                    bitmap = image.asImageBitmap(),
                    contentDescription = stringResource(R.string.hero_image),
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(200.dp)
                        .shadow(8.dp),
                    contentScale = ContentScale.Crop
                )
            }
        }
        LazyColumn {
            itemsIndexed(
                items = caseStudy.sections!!
            ) { _, section ->
                SectionCard(section = section)
            }
        }
    }
}