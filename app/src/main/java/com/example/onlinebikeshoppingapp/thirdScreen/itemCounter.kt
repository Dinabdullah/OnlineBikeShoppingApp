package com.example.onlinebikeshoppingapp.thirdScreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.onlinebikeshoppingapp.R

@Composable
fun ItemCounter(
    itemId: Int,
    modifier: Modifier = Modifier,
    viewModel: ShoppingCartViewModel
) {
    val count by viewModel.getCount(itemId).collectAsState()

    Row(
        modifier = modifier
            .shadow(
                elevation = 4.dp,
                shape = RoundedCornerShape(dimensionResource(id = R.dimen.corner_radius)),
                ambientColor = colorResource(id = R.color.card_background),
                spotColor = colorResource(id = R.color.card_background)
            )
            .clip(RoundedCornerShape(dimensionResource(id = R.dimen.corner_radius)))
            .background(
                color = colorResource(id = R.color.counter_background),
                shape = RoundedCornerShape(dimensionResource(id = R.dimen.corner_radius))
            ),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(id = R.drawable.minusitem),
            contentDescription = null,
            modifier = Modifier
                .padding(dimensionResource(id = R.dimen.padding_small))
                .clickable { viewModel.decrease(itemId) }
        )

        Text(
            text = count.toString(),
            style = TextStyle(
                fontWeight = FontWeight.Bold,
                fontSize = dimensionResource(id = R.dimen.counter_text_size).value.sp,
                textAlign = TextAlign.Center,
                color = Color.White
            )
        )

        Image(
            painter = painterResource(id = R.drawable.additem),
            contentDescription = null,
            modifier = Modifier
                .padding(dimensionResource(id = R.dimen.padding_small))
                .clickable { viewModel.increase(itemId) }
        )
    }
}


@Preview
@Composable
private fun ItemCounterPreview() {
    ItemCounter(itemId = 1, viewModel = viewModel())
}
