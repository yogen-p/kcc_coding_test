package com.yogenp.codingtest.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.yogenp.codingtest.R
import com.yogenp.codingtest.domain.model.CaseStudy
import com.yogenp.codingtest.util.DEFAULT_PLACEHOLDER_IMAGE
import com.yogenp.codingtest.util.loadImage

/*
* Composable for HomeScreen list of case studies
* Hero Image + Teaser
* */
@Composable
fun CaseStudyCard(
    caseStudy: CaseStudy,
    onClick: () -> Unit
) {
    Card(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth()
            .clickable(onClick = onClick),
        shape = MaterialTheme.shapes.small.copy(CornerSize(6.dp)),
        elevation = 8.dp
    ) {
        Column {
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
                            .height(200.dp),
                        contentScale = ContentScale.Crop
                    )
                }
            }

            caseStudy.teaser?.let { teaser ->
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 12.dp, bottom = 12.dp, start = 8.dp, end = 8.dp)
                ) {
                    Text(
                        text = teaser,
                        modifier = Modifier
                            .fillMaxWidth(),
                        style = MaterialTheme.typography.h6,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                }
            }
        }
    }
}