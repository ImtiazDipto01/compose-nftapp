package com.imtiaz.composenftapp.data

import com.imtiaz.composenftapp.R
import java.util.UUID

data class Rankings(
    val title: String,
    val image: Int,
    var percentChange: Double = 0.0,
    var eth: Double = 0.0,
    val id: UUID = UUID.randomUUID()
)

var rankings = listOf<Rankings> (
    Rankings("Azumi", R.drawable.ranking01, 3.99, 200055.02),
    Rankings("Hape Prime", R.drawable.ranking02, 33.79, 180055.45),
    Rankings("Cryoto", R.drawable.ranking03, -6.56, 90055.62),
    Rankings("Ape Club", R.drawable.ranking04, 3.99, 88055.12),
    Rankings("Bat", R.drawable.ranking05, 3.99, 10055.06),
    Rankings("Mutant", R.drawable.ranking06, 3.99, 9095.27),
    Rankings("Metaverse", R.drawable.ranking07, -3.53, 2342.4),
    Rankings("Mountain", R.drawable.ranking08, 5.23, 2349024.02),
    Rankings("Mutant Ape", R.drawable.ranking05, -23.4, 93492.02),
    Rankings("The Mountain", R.drawable.ranking10, 302.3, 239802.3),
)