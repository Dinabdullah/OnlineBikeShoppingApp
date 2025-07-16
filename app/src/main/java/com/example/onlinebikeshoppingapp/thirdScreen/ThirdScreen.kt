package com.example.onlinebikeshoppingapp.thirdScreen

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.onlinebikeshoppingapp.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ThirdScreen(
    modifier: Modifier = Modifier
) {
    val viewModel: ShoppingCartViewModel = viewModel()
    val state by viewModel.state.collectAsStateWithLifecycle()

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = colorResource(id = R.color.card_background),
                    titleContentColor = Color.White,
                ),
                navigationIcon = {
                    Box(
                        modifier = Modifier
                            .padding(start = dimensionResource(id = R.dimen.dp_20))
                            .padding(vertical = dimensionResource(id = R.dimen.dp_10))
                            .width(dimensionResource(id = R.dimen.dp_44))
                            .height(dimensionResource(id = R.dimen.dp_44))
                            .clip(RoundedCornerShape(dimensionResource(id = R.dimen.dp_10)))
                            .gradientBackground()
                            .clickable { },
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.baseline_keyboard_arrow_left_24),
                            contentDescription = null,
                            tint = Color.White
                        )
                    }
                },
                title = {
                    Text(
                        stringResource(R.string.my_shopping_cart),
                        maxLines = 1,
                    )
                }
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .background(colorResource(id = R.color.card_background))
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            LazyColumn(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxWidth()
            ) {
                items(state.items) { item ->
                    CustomShoppingCartItem(
                        item = item,
                        onDecrease = { viewModel.onEvent(CartEvent.Decrease(item.id)) },
                        onIncrease = { viewModel.onEvent(CartEvent.Increase(item.id)) }
                    )
                }
            }

            Column(modifier = Modifier
                .fillMaxWidth()
                .weight(1f)) {
                Text(
                    stringResource(R.string.your_bag_qualifies_for_free_shipping),
                    fontSize = 15.sp,
                    color = Color.White,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = dimensionResource(id = R.dimen.dp_10))

                )

                ApplyCodeRow(onClick = {
                    viewModel.onEvent(CartEvent.CalculateTotal)
                })

                if (state.subtotal > 0) {
                    PriceDetails(
                        total = state.total,
                        subtotal = state.subtotal
                    )
                }
            }
        }
    }
}

fun Modifier.gradientBackground(): Modifier {
    return this.background(
        brush = Brush.linearGradient(
            colors = listOf(
                Color(0xFF34C8E8),
                Color(0xFF4E4AF2)
            )
        )
    )
}

@Preview
@Composable
private fun ThirdScreenPreview() {
    ThirdScreen()
}
