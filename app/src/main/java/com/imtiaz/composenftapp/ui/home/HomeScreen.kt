package com.imtiaz.composenftapp.ui.home

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.imtiaz.composenftapp.ui.theme.ComposeNFTAppTheme

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun HomeScreen() {
    Scaffold(
        topBar = {
            TopAppBar(
                content = {
                    Text(
                        text = "NFT Marketplace",
                        modifier = Modifier.fillMaxWidth(),
                        style = MaterialTheme.typography.h2.copy(fontSize = 24.sp)
                    )
                },
                backgroundColor = Color.Transparent,
                elevation = 0.dp
            )
        },
        backgroundColor = Color(33, 17, 52)
    ) {
        Column(
            modifier = Modifier
                .padding(horizontal = 12.dp)
                .verticalScroll(rememberScrollState())
        ) {
            CategoryList()
            Text(
                text = "Trending Collection",
                style = MaterialTheme.typography.h5
            )
            CollectionList()
            Text(
                text = "Top Seller",
                style = MaterialTheme.typography.h5
            )
            NFTList()
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