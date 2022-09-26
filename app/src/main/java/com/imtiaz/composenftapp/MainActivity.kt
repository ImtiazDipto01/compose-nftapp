package com.imtiaz.composenftapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
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
import com.imtiaz.composenftapp.ui.theme.ComposeNFTAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeNFTAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    //Greeting("Android")
                    OnBoardingCard()
                }
            }
        }
    }
}

@Composable
fun OnBoardingCard() {
    Scaffold {
        Box {
            Image(
                painter = painterResource(id = R.drawable.bg1),
                contentDescription = "Layout Background",
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop
            )
            Column(
                modifier = Modifier
                    .padding(horizontal = 32.dp, vertical = 80.dp)
                    .fillMaxSize()
            ) {
                Text(
                    text = "Welcome to NFT Marketplace",
                    color = Color.White,
                    fontSize = 36.sp,
                    fontWeight = FontWeight.Black
                )
                Spacer(modifier = Modifier.fillMaxHeight(0.65f))
                Card(
                    /*shape = RoundedCornerShape(35.dp),*/
                    elevation = 4.dp,
                    modifier = Modifier
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
                        modifier = Modifier.fillMaxSize(),
                        contentScale = ContentScale.Crop
                    )
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        modifier = Modifier.padding(27.dp)
                    ) {
                        Text(
                            text = "Explore and Mint NFTs",
                            textAlign = TextAlign.Center,
                            color = Color.White,
                            fontWeight = FontWeight.Bold,
                            fontSize = 20.sp
                        )
                        Text(
                            text = "You can buy and sell the NFTs of the best artists in the world.",
                            textAlign = TextAlign.Center,
                            color = Color.White.copy(0.8f)
                        )
                        Spacer(
                            modifier = Modifier
                                .padding(bottom = 27.dp)
                        )
                        Button(
                            onClick = { /*TODO*/ },
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
                                fontSize = 15.sp,
                                fontWeight = FontWeight.SemiBold
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
        OnBoardingCard()
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}
