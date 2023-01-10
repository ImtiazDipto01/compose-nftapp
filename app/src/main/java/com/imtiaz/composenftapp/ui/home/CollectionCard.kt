package com.imtiaz.composenftapp.ui.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.IconToggleButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.imtiaz.composenftapp.data.collections
import com.imtiaz.composenftapp.ui.theme.ComposeNFTAppTheme
import com.imtiaz.composenftapp.R

@Composable
fun CollectionCard(
    title: String,
    image: Painter,
    likes: Int
) {
    Column(
        modifier = Modifier
            .width(216.dp)
            .height(216.dp)
            .border(
                width = 1.dp,
                color = Color.Red.copy(0.5f),
                shape = RoundedCornerShape(30.dp)
            )
    ) {
        Image(
            painter = image,
            contentDescription = "Collection Image",
            modifier = Modifier
                .width(155.dp)
                .height(155.dp)
                .padding(10.dp)
                .border(
                    width = 1.dp,
                    color = Color.Transparent,
                    shape = RoundedCornerShape(22.dp)
                )
                .fillMaxSize()
                .clip(RoundedCornerShape(22.dp))
        )
        Row(
            modifier = Modifier.padding(10.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = title,
                fontSize = 13.sp,
                fontWeight = FontWeight.SemiBold,
                textAlign = TextAlign.Left,
                color = Color.White
            )
            Spacer(modifier = Modifier.weight(1f))
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(4.dp)
            ) {
                IconToggleButton(checked = true, onCheckedChange = {

                }) {
                    Icon(
                        tint = Color.Red,
                        imageVector = Icons.Filled.Favorite,
                        contentDescription = "Favourite Button",
                    )
                }
                Text(
                    text = likes.toString(),
                    fontSize = 11.sp,
                    textAlign = TextAlign.Right,
                    color = Color(235, 235, 245).copy(0.6f)
                )
            }

        }
    }
}

@Preview
@Composable
fun PreviewCollectionCard() {
    ComposeNFTAppTheme {
        CollectionCard(
            collections[0].title,
            painterResource(id = collections[0].image),
            collections[0].likes
        )
    }
}