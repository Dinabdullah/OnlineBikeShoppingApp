package com.example.onlinebikeshoppingapp.thirdScreen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.onlinebikeshoppingapp.R

@Composable
fun ThirdScreen(modifier: Modifier = Modifier) {
    val items = listOf(
        BikeItem(R.drawable.bike1, R.string.title1, R.string.price1),
        BikeItem(R.drawable.bike2, R.string.title2, R.string.price2),
        BikeItem(R.drawable.bike3, R.string.title3, R.string.price3)
    )

    LazyColumn(modifier = modifier) {
        itemsIndexed(items) { index, item ->
            val viewModel: ItemCounterViewModel = viewModel(key = "item_$index")

            CustomShoppingCartItem(
                imageRes = item.imageRes,
                title = item.titleRes,
                price = item.priceRes,
                itemCounterViewModel = viewModel
            )
        }
    }
}



@Preview
@Composable
private fun ThirdScreenPreview() {
    ThirdScreen()
}