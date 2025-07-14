package com.example.onlinebikeshoppingapp.thirdScreen

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.onlinebikeshoppingapp.R

@Composable
fun CustomShoppingCartItem(
    modifier: Modifier = Modifier,
    item: BikeItem,
    viewModel: ShoppingCartViewModel
) {
    Row(
        modifier = modifier
            .background(colorResource(id = R.color.shadow_color))
            .width(390.dp)
            .height(120.dp)
            .padding(horizontal = 16.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {

        CustomItem(
            imageRes = item.imageRes,
            modifier = Modifier
                .width(100.dp)
                .height(90.dp)
        )

        Column(
            modifier = Modifier
                .weight(1f)
                .padding(start = 12.dp)
                .fillMaxHeight(),
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.Start
        ) {
            Text(
                text = stringResource(id = item.titleRes),
                style = TextStyle(
                    fontWeight = FontWeight.Bold,
                    fontSize = 15.sp,
                    color = Color.White
                )
            )
            Text(
                text = stringResource(id = item.priceRes),
                style = TextStyle(
                    fontSize = 13.sp,
                    color = colorResource(id = R.color.price_blue)
                )
            )
        }
        ItemCounter(
            itemId = item.id, viewModel = viewModel, modifier = Modifier
                .padding(top = 50.dp)
        )

    }

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(0.5.dp)
            .background(Color.White.copy(alpha = 0.3f))
    )
}


@SuppressLint("ViewModelConstructorInComposable")
@Preview(showBackground = true)
@Composable
private fun CustomShoppingCartItemPreview() {
    val dummyItem = BikeItem(
        id = 1,
        imageRes = R.drawable.bike2,
        titleRes = R.string.title1,
        priceRes = R.string.price1
    )
    val dummyViewModel = ShoppingCartViewModel()

    CustomShoppingCartItem(
        item = dummyItem,
        viewModel = dummyViewModel
    )
}


