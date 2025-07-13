package com.example.onlinebikeshoppingapp.thirdScreen

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.onlinebikeshoppingapp.R

@Composable
fun ThirdScreen(modifier: Modifier = Modifier) {
    val viewModel1: ItemCounterViewModel = viewModel(key = "item1")
    val viewModel2: ItemCounterViewModel = viewModel(key = "item2")
    val viewModel3: ItemCounterViewModel = viewModel(key = "item3")
    Column {
        CustomShoppingCartItem(
            imageRes = R.drawable.bike1,
            title = R.string.title1,
            price = R.string.price1,
            itemCounterViewModel = viewModel1
        )
        CustomShoppingCartItem(
            imageRes = R.drawable.bike2,
            title = R.string.title2,
            price = R.string.price2,
            itemCounterViewModel = viewModel2
        )
        CustomShoppingCartItem(
            imageRes = R.drawable.bike3,
            title = R.string.title3,
            price = R.string.price3,
            itemCounterViewModel = viewModel3
        )

    }
}


@Preview
@Composable
private fun ThirdScreenPreview() {
    ThirdScreen()
}