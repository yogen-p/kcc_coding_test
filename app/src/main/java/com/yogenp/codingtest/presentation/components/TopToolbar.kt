package com.yogenp.codingtest.presentation.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.NightlightRound
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

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
                    .height(50.dp)
            ) {
                Text(
                    text = text,
                    modifier = Modifier
                        .padding(8.dp)
                        .fillMaxWidth(0.85f)
                        .wrapContentWidth(Alignment.Start)
                        .align(Alignment.CenterVertically),
                    style = MaterialTheme.typography.h6
                )
                IconButton(onClick = { onClick() }) {
                    Icon(
                        imageVector = Icons.Filled.NightlightRound,
                        contentDescription = "Toggle theme",
                        modifier = Modifier
                            .padding(8.dp)
                            .wrapContentWidth(Alignment.End)
                            .align(Alignment.CenterVertically)
                    )
                }
            }
        }
    }

}