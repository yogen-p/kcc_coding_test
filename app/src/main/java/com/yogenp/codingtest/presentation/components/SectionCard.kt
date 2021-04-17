package com.yogenp.codingtest.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.material.Card
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.yogenp.codingtest.R
import com.yogenp.codingtest.network.responses.SectionsResponse
import com.yogenp.codingtest.util.DEFAULT_PLACEHOLDER_IMAGE
import com.yogenp.codingtest.util.loadImage

/*
* Composable for a single section
* */
@Composable
fun SectionCard(
    section: SectionsResponse
) {
    Card(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth(),
        shape = MaterialTheme.shapes.small.copy(CornerSize(6.dp)),
        elevation = 8.dp
    ) {
        Column {
            section.title?.let {
                Text(
                    text = it,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp),
                    style = MaterialTheme.typography.h5
                )
                Divider(
                    color = MaterialTheme.colors.onSurface,
                    thickness = 1.dp
                )
            }
            for (element in section.bodyElements) {
                val s = element.toString()
                if (s.startsWith("{image_url", true)) {
                    val url = s.substring(11, s.length - 1)
                    url.let {
                        val image = loadImage(
                            url = it,
                            defaultImage = DEFAULT_PLACEHOLDER_IMAGE
                        ).value
                        image?.let {
                            Image(
                                bitmap = image.asImageBitmap(),
                                contentDescription = stringResource(R.string.section_image),
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(150.dp)
                                    .padding(8.dp),
                                contentScale = ContentScale.FillHeight
                            )
                        }
                    }
                } else {
                    Text(
                        text = element.toString(),
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(8.dp)
                            .wrapContentWidth(Alignment.Start),
                        style = MaterialTheme.typography.body1
                    )
                }
            }
        }
    }

}