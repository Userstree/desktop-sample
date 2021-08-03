package common

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun DataTable() {
    LazyVerticalGrid(
        modifier = Modifier // 1
            .fillMaxSize()
            .background(Color(0xFFE53935))
            .padding(8.dp),
        cells = GridCells.Fixed(10), // 2
    ) {
        items(count = 100) { // 3
            Box(
                Modifier // 4
                    .aspectRatio(1f)
                    .padding(1.dp)
                    .background(Color.DarkGray)
            )
        }
    }
}