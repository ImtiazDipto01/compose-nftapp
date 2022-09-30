package com.imtiaz.composenftapp.data

import com.imtiaz.composenftapp.R

data class NFTCollection(
    val title: String,
    val image: Int,
    var likes: Int
)

val collections = listOf<NFTCollection>(
    NFTCollection("3rd Art", R.drawable.card_3d, 123),
    NFTCollection("Abstract Arts", R.drawable.card_abstract, 200),
    NFTCollection("Portrait Art", R.drawable.card_portrait, 242),
    NFTCollection("Metaverse", R.drawable.card_metaverse, 420)
)