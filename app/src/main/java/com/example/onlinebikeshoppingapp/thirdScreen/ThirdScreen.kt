package com.example.onlinebikeshoppingapp.thirdScreen

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
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
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.onlinebikeshoppingapp.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ThirdScreen(
    modifier: Modifier = Modifier
) {
    val viewModel: ShoppingCartViewModel = viewModel()
    var applyCodeState by remember { mutableStateOf("") }
    var isPromoApplied by remember { mutableStateOf(false) }
    var subtotal by remember { mutableStateOf(0.0) }
    var total by remember { mutableStateOf(0.0) }


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
                            .padding(start = 15.dp)
                            .width(44.dp)
                            .height(44.dp)
                            .clip(RoundedCornerShape(10.dp))
                            .background(
                                brush = Brush.linearGradient(
                                    colors = listOf(
                                        Color(0xFF34C8E8),
                                        Color(0xFF4E4AF2)
                                    )
                                )
                            )
                            .clickable { /* Handle click here */ },
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
                        "Centered Top App Bar",
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                }
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .background(colorResource(id = R.color.card_background))
                .fillMaxSize()
        ) {
            LazyColumn(modifier = modifier.padding(paddingValues)) {
                items(viewModel.items.value) { item ->
                    CustomShoppingCartItem(
                        item = item,
                        onDecrease = { viewModel.decrease(item.id) },
                        onIncrease = { viewModel.increase(item.id) }
                    )
                }
            }
            Text(
                "Your bag qualifies for free shipping",
                fontSize = 15.sp,
                color = Color.White,
                textAlign = TextAlign.Center,
                modifier = modifier
                    .padding(top = 24.dp)
                    .padding(horizontal = 70.dp)
            )
            ApplyCodeRow(onClick = {
                applyCodeState = it
                isPromoApplied = true
                subtotal = viewModel.items.value.sumOf { item ->
                    item.price * item.count.value
                }
                total = subtotal
            })
            if (isPromoApplied) {
                PriceDetails(
                    total = total,
                    subtotal = subtotal
                )
            }

        }


    }
}

@Preview
@Composable
private fun ThirdScreenPreview() {
    ThirdScreen()
}
