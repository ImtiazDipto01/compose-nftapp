package com.imtiaz.composenftapp.ui.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.imtiaz.composenftapp.data.collections
import com.imtiaz.composenftapp.data.nfts
import com.imtiaz.composenftapp.ui.theme.ComposeNFTAppTheme

/**
 * ...
 *
 *
 * Copyright (c) 2023 Compose NFT. All rights reserved.
 *
 * @author Imtiaz Dipto.
 * @since 7/5/23 1:37 AM
 */

@Composable
fun NFTList() {
    LazyRow(
        modifier = Modifier.padding(bottom = 30.dp, top = 8.dp),
        horizontalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        items(nfts) { nft ->
            NftCard(
                title = nft.title,
                subTitle = nft.subTitle,
                image = painterResource(id = nft.image),
                liked = nft.likes,
                eth = nft.eth
            )
        }
    }
}

@Preview
@Composable
fun PreviewNFTList() {
    ComposeNFTAppTheme {
        NFTList()
    }
}