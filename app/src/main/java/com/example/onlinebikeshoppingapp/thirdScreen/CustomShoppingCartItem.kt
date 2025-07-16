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
import androidx.compose.ui.res.dimensionResource
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
    onIncrease: () -> Unit,
    onDecrease: () -> Unit
) {
    Row(
        modifier = modifier
            .background(colorResource(id = R.color.shadow_color))
            .width(dimensionResource(id = R.dimen.dp_390))
            .height(dimensionResource(id = R.dimen.dp_120))
            .padding(horizontal = dimensionResource(id = R.dimen.dp_16)),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {

        ProductImage(
            imageRes = item.imageRes,
            modifier = Modifier
                .width(dimensionResource(id = R.dimen.dp_100))
                .height(dimensionResource(id = R.dimen.dp_90))
        )

        Column(
            modifier = Modifier
                .weight(1f)
                .padding(start = dimensionResource(id = R.dimen.dp_12))
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
                text = "$${String.format("%.2f", item.price)}",
                style = TextStyle(
                    fontSize = 13.sp,
                    color = colorResource(id = R.color.price_blue)
                )
            )
        }

        ItemCounter(
            item = item,
            modifier = Modifier.padding(top = dimensionResource(id = R.dimen.dp_50)),
            onDecrease = onDecrease,
            onIncrease = onIncrease
        )
    }

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(dimensionResource(id = R.dimen.dp_0_5))
            .background(Color.White.copy(alpha = 0.3f))
    )
}


@SuppressLint("UnrememberedMutableState")
@Preview()
@Composable
private fun CustomShoppingCartItemPreview() {
    val dummyItem = BikeItem(
        id = 1,
        imageRes = R.drawable.bike2,
        titleRes = R.string.title1,
        price = 10.0
    )

    CustomShoppingCartItem(
        item = dummyItem,
        onIncrease = {},
        onDecrease = {}
    )
}



