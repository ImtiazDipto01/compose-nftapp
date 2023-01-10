package com.imtiaz.composenftapp.ui.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.imtiaz.composenftapp.ui.theme.ComposeNFTAppTheme

@Composable
fun HomeScreen() {
    Scaffold(
        backgroundColor = Color(33, 17, 52)
    ) {
        Column(
            modifier = Modifier.padding(horizontal = 12.dp)
        ) {
            CategoryList()
            Text(
                text = "Trending Collection",
                fontSize = 20.sp,
                color = Color.White,
                fontWeight = FontWeight.SemiBold
            )
        }
    }
}

@Preview
@Composable
fun PreviewHomeScreen() {
    ComposeNFTAppTheme {
        HomeScreen()
    }
}