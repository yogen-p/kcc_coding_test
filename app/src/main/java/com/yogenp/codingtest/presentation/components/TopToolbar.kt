package com.yogenp.codingtest.presentation.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.NightlightRound
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.yogenp.codingtest.R

@Composable
fun TopToolbar(
    text: String,
    onClick: () -> Unit
) {
    Surface(
        modifier = Modifier.fillMaxWidth(),
        elevation = 8.dp,
        color = MaterialTheme.colors.secondary
    ) {
        Column {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(60.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = text,
                    modifier = Modifier
                        .padding(start = 10.dp)
                        .fillMaxWidth(0.85f)
                        .wrapContentWidth(Alignment.Start),
                    style = MaterialTheme.typography.h6
                )
                IconButton(onClick = { onClick() }) {
                    Icon(
                        imageVector = Icons.Filled.NightlightRound,
                        contentDescription = stringResource(R.string.toggle_theme),
                        modifier = Modifier
                            .fillMaxSize()
                            .wrapContentWidth(Alignment.End)
                    )
                }
            }
        }
    }

}