package com.example.onlinebikeshoppingapp.thirdScreen

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun ThirdScreen(
    modifier: Modifier = Modifier
) {
    val viewModel: ShoppingCartViewModel = viewModel()
    val items by viewModel.items.collectAsState()

    LazyColumn(modifier = modifier) {
        items(items) { item ->
            CustomShoppingCartItem(
                item = item,
                onDecrease = { viewModel.decrease(item.id) },
                onIncrease = { viewModel.increase(item.id) }
            )
        }
    }
}


@Preview
@Composable
private fun ThirdScreenPreview() {
    ThirdScreen()
}