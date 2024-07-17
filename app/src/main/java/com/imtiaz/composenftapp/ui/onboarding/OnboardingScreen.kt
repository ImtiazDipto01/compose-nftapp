package com.imtiaz.composenftapp.ui.onboarding

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.imtiaz.composenftapp.R
import com.imtiaz.composenftapp.ui.theme.ComposeNFTAppTheme
import com.imtiaz.composenftapp.ui.theme.NFTTypography

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun OnBoardingScreen(
    onNavigationEvent: () -> Unit
) {
    Scaffold {
        Box {
            Image(
                painter = painterResource(id = R.drawable.bg1),
                contentDescription = "Layout Background",
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.FillBounds
            )
            Column(
                modifier = Modifier
                    .padding(horizontal = 32.dp, vertical = 80.dp)
                    .fillMaxSize()
            ) {
                Text(
                    text = "Welcome to NFT Marketplace",
                    style = NFTTypography.h1
                )
                Spacer(modifier = Modifier.weight(1f))
                Card(
                    /*shape = RoundedCornerShape(35.dp),*/
                    elevation = 0.dp,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(200.dp)
                        .border(
                            width = 1.dp,
                            color = Color.White.copy(alpha = 0.1f),
                            shape = RoundedCornerShape(27.dp)
                        )
                        .clip(shape = RoundedCornerShape(27.dp)),
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.cardblur),
                        contentDescription = "card Background",
                        modifier = Modifier
                            .fillMaxSize()
                            .border(
                                width = 1.dp,
                                color = Color.Transparent,
                                shape = RoundedCornerShape(27.dp)
                            )
                            .clip(RoundedCornerShape(27.dp)),
                        contentScale = ContentScale.Crop
                    )
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        modifier = Modifier.padding(27.dp)
                    ) {
                        Text(
                            text = "Explore and Mint NFTs",
                            style = MaterialTheme.typography.body2
                        )
                        Text(
                            text = "You can buy and sell the NFTs of the best artists in the world.",
                            textAlign = TextAlign.Center,
                            color = Color.White.copy(0.8f),
                            fontSize = 14.sp,
                            modifier = Modifier.padding(top = 4.dp)
                        )
                        Spacer(
                            modifier = Modifier
                                .padding(bottom = 27.dp)
                        )
                        Button(
                            onClick = onNavigationEvent,
                            modifier = Modifier
                                .border(
                                    width = 1.dp,
                                    color = Color.White.copy(alpha = 0.5f),
                                    shape = RoundedCornerShape(percent = 50)
                                ),
                            colors = ButtonDefaults.buttonColors(
                                backgroundColor = Color(
                                    151,
                                    169,
                                    246,
                                    alpha = 0x32
                                ),
                                contentColor = Color.White
                            ),
                            shape = RoundedCornerShape(percent = 50),
                        ) {
                            Text(
                                text = "Get started now",
                                modifier = Modifier.padding(horizontal = 40.dp, vertical = 4.dp),
                                style = MaterialTheme.typography.button
                            )
                        }
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun OnBoardingCardPreview() {
    ComposeNFTAppTheme {
        OnBoardingScreen {

        }
    }
}