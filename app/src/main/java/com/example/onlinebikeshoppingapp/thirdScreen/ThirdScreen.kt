package com.example.onlinebikeshoppingapp.thirdScreen

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.onlinebikeshoppingapp.R

@Composable
fun ThirdScreen(modifier: Modifier = Modifier) {
    Column {
        CustomShoppingCartItem(
            imageRes = R.drawable.bike1,
            title = R.string.title1,
            price = R.string.price1
        )
        CustomShoppingCartItem(
            imageRes = R.drawable.bike2,
            title = R.string.title2,
            price = R.string.price2
        )
        CustomShoppingCartItem(
            imageRes = R.drawable.bike3,
            title = R.string.title3,
            price = R.string.price3
        )

    }
}


@Preview
@Composable
private fun ThirdScreenPreview() {
    ThirdScreen()
}