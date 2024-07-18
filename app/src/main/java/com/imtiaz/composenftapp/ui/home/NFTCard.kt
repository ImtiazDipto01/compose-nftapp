package com.imtiaz.composenftapp.ui.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.IconToggleButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.imtiaz.composenftapp.R
import com.imtiaz.composenftapp.data.nfts
import com.imtiaz.composenftapp.ui.theme.ComposeNFTAppTheme

/**
 * ...
 *
 *
 * Copyright (c) 2023 compose nft. All rights reserved.
 *
 * @author Imtiaz Dipto.
 * @since 7/5/23 12:27 AM
 */

@Composable
fun NftCard(
    title: String,
    subTitle: String,
    image: Painter,
    liked: Int,
    eth: Double
) {
    var isLiked by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .height(262.dp)
            .width(175.dp)
            .border(
                1.dp,
                Color.White.copy(0.5f),
                RoundedCornerShape(30.dp)
            )
            .clip(RoundedCornerShape(30.dp))
            .background(Color.White.copy(0.2f))
    ) {
        Image(
            painter = image,
            contentDescription = "",
            modifier = Modifier
                .height(155.dp)
                .width(155.dp)
                .padding(10.dp)
                .border(
                    1.dp,
                    Color.Transparent,
                    RoundedCornerShape(27.dp)
                )
                .clip(RoundedCornerShape(27.dp)),
            contentScale = ContentScale.Crop
        )
        Column(
            modifier = Modifier
                .padding(horizontal = 10.dp, vertical = 10.dp)
        ) {
            Text(
                text = title,
                style = MaterialTheme.typography.subtitle1
            )
            Text(
                text = subTitle,
                style = MaterialTheme.typography.subtitle2
            )
        }
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(horizontal = 10.dp)
        ) {
            Row(
                horizontalArrangement = Arrangement.spacedBy(4.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(id = R.drawable.icon_eth),
                    contentDescription = "Icon",
                    modifier = Modifier.size(13.dp)
                )
                Text(
                    text = eth.toString(),
                    style = MaterialTheme.typography.subtitle2,
                    color = Color.White
                )
            }
            Spacer(modifier = Modifier.weight(1f))
            Row(
                horizontalArrangement = Arrangement.spacedBy(4.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                IconToggleButton(
                    checked = isLiked,
                    modifier = Modifier.size(13.dp),
                    onCheckedChange = {
                        isLiked = !isLiked
                    }
                ) {
                    Icon(
                        tint = if (isLiked) {
                            Color.Red
                        } else {
                            Color(235, 235, 245).copy(0.6f)
                        },
                        imageVector = if (isLiked) {
                            Icons.Filled.Favorite
                        } else {
                            Icons.Default.FavoriteBorder
                        },
                        contentDescription = "Icon Liked"
                    )
                }
                Text(
                    text = liked.toString(),
                    style = MaterialTheme.typography.subtitle2
                )
            }
        }
    }
}

@Preview
@Composable
fun PreviewNftCard() {
    ComposeNFTAppTheme {
        NftCard(
            title = nfts[0].title,
            subTitle = nfts[0].subTitle,
            image = painterResource(id = nfts[0].image),
            liked = nfts[0].likes,
            eth = nfts[0].eth
        )
    }
}