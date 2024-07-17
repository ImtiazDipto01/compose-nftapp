package com.imtiaz.composenftapp.ui.stats

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.imtiaz.composenftapp.data.Rankings
import com.imtiaz.composenftapp.data.rankings
import com.imtiaz.composenftapp.ui.theme.ComposeNFTAppTheme

/**
 * ...
 *
 *
 * Copyright (c) 2023 imtiaz. All rights reserved.
 *
 * @author Imtiaz Dipto.
 * @since 10/8/23 12:56 AM
 */

@Composable
fun RankingList(rankings: List<Rankings>) {
    LazyColumn(
        modifier = Modifier.padding(vertical = 20.dp, horizontal = 16.dp),
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        itemsIndexed(rankings) {index, item ->
            RankingRow(
                index = index,
                title = item.title,
                image = item.image,
                change = item.percentChange,
                eth = item.eth
            )
        }
    }
}

@Preview
@Composable
fun RankingListPreview() {
    ComposeNFTAppTheme {
        RankingList(rankings = rankings)
    }
}