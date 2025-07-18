package com.example.onlinebikeshoppingapp.thirdScreen

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.onlinebikeshoppingapp.R

@Composable
fun CheckoutRow(modifier: Modifier = Modifier) {
    Row(
        modifier = modifier
            .padding(horizontal = dimensionResource(id = R.dimen.dp_20), vertical = dimensionResource(id = R.dimen.dp_16))
            .width(dimensionResource(id = R.dimen.dp_174))
            .height(dimensionResource(id = R.dimen.dp_44))
            .shadow(
                elevation = dimensionResource(id = R.dimen.dp_4),
                shape = RoundedCornerShape(dimensionResource(id = R.dimen.dp_8)),
                ambientColor = colorResource(id = R.color.card_background),
                spotColor = colorResource(id = R.color.card_background)
            )
            .clip(RoundedCornerShape(dimensionResource(id = R.dimen.dp_8)))
            .background(
                color = colorResource(id = R.color.counter_background),
                shape = RoundedCornerShape(dimensionResource(id = R.dimen.dp_8))
            ),
        horizontalArrangement = Arrangement.Start,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = Modifier
                .width(dimensionResource(id = R.dimen.dp_44))
                .height(dimensionResource(id = R.dimen.dp_44))
                .clip(RoundedCornerShape(dimensionResource(id = R.dimen.dp_10)))
                .gradientBackground()
                .clickable { },
            contentAlignment = Alignment.Center
        ) {
            Icon(
                painter = painterResource(id = R.drawable.baseline_keyboard_arrow_right_24),
                contentDescription = null,
                tint = Color.White
            )
        }
        Text(
            stringResource(R.string.checkout),
            textAlign = TextAlign.Center,
            color = Color.Gray,
            fontSize = 15.sp,
            fontWeight = FontWeight.Medium,
            modifier = modifier.fillMaxWidth()
        )

    }
}

@Preview
@Composable
private fun CheckoutRowPreview() {
    CheckoutRow()
}