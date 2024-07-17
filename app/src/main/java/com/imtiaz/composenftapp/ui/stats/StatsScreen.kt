package com.imtiaz.composenftapp.ui.stats

import android.annotation.SuppressLint
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.Tab
import androidx.compose.material.TabPosition
import androidx.compose.material.TabRow
import androidx.compose.material.TabRowDefaults
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Assessment
import androidx.compose.material.icons.filled.TrackChanges
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.imtiaz.composenftapp.data.rankings
import com.imtiaz.composenftapp.ui.theme.ComposeNFTAppTheme

/**
 *
 * Copyright (c) 2023 Imtiaz Dipto. All rights reserved.
 *
 * @author Imtiaz Dipto.
 * @since 24/8/23 1:02 AM
 */

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun StatsScreen() {
    Scaffold(
        backgroundColor = Color(33, 17, 52),
        topBar = {
            TopAppBar(
                content = {
                    Column {
                        Text(
                            text = "Stats",
                            fontSize = 24.sp,
                            fontWeight = FontWeight.SemiBold,
                            color = Color.White,
                            modifier = Modifier.fillMaxWidth(),
                            textAlign = TextAlign.Center
                        )
                    }
                },
                backgroundColor = Color.Transparent,
                elevation = 0.dp
            )
        }
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(bottom = 30.dp)
        ) {
            CustomTabComponent()
            Card(
                backgroundColor = Color.White.copy(0.15f),
                elevation = 0.dp,
                shape = RoundedCornerShape(20.dp),
                border = BorderStroke(width = 1.5.dp, color = Color.White.copy(0.5f)),
                modifier = Modifier.padding(horizontal = 16.dp, vertical = 20.dp)
            ) {
                RankingList(rankings = rankings)
            }
        }
    }
}

@Composable
fun CustomTabComponent() {
    val tabIndex = remember { mutableStateOf(0) }
    val tabData = listOf(
        "Ranking" to Icons.Default.Assessment,
        "Activity" to Icons.Default.TrackChanges
    )
    TabRow(
        selectedTabIndex = tabIndex.value,
        backgroundColor = Color.Transparent,
        contentColor = Color.White,
        divider = {
            TabRowDefaults.Divider(
                thickness = 1.dp,
                color = Color(66, 34, 104)
            )
        },
        indicator = { tabPositions ->
            TabRowDefaults.Indicator(
                modifier = Modifier.customTabOffset(tabPositions[tabIndex.value]),
                height = 4.dp,
                color = Color(148, 103, 255)
            )
        }
    ) {
        tabData.forEachIndexed { index, pair ->
            Tab(
                selected = index == tabIndex.value,
                onClick = { tabIndex.value = index },
                content = {
                   Row(
                       horizontalArrangement = Arrangement.spacedBy(8.dp),
                       verticalAlignment = Alignment.CenterVertically,
                       modifier = Modifier.padding(bottom = 16.dp)
                   ) {
                       Icon(
                           imageVector = pair.second,
                           contentDescription = null
                       )
                       Text(
                           text = pair.first,
                           fontWeight = FontWeight.SemiBold,
                           fontSize = 17.sp,
                           color = Color.White
                       )
                   }
                }
            )
        }
    }
}

fun Modifier.customTabOffset(tabPosition: TabPosition) = composed {
    val indicatorWidth = 118.dp
    val currentTabWidth = tabPosition.width
    val indicatorOffset by animateDpAsState(
        targetValue = tabPosition.left + currentTabWidth / 2 - indicatorWidth / 2,
        animationSpec = tween(durationMillis = 1000, easing = FastOutSlowInEasing)
    )

    fillMaxWidth()
        .wrapContentSize(Alignment.BottomStart)
        .offset(x = indicatorOffset)
        .width(indicatorWidth)
}

@Preview
@Composable
fun PreviewStatsScreen() {
    ComposeNFTAppTheme {
        StatsScreen()
    }
}