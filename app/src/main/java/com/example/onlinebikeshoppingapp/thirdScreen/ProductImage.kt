package com.example.onlinebikeshoppingapp.thirdScreen

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.onlinebikeshoppingapp.R

@Composable
fun ProductImage(
    @DrawableRes imageRes: Int,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .padding((dimensionResource(id = R.dimen.padding_small)))
            .width((dimensionResource(id = R.dimen.image_size)))
            .height((dimensionResource(id = R.dimen.image_size)))
            .background(
                brush = Brush.linearGradient(
                    colors = listOf(
                        colorResource(id = R.color.gradient_start),
                        colorResource(id = R.color.gradient_end)
                    )
                ),
                shape = RoundedCornerShape((dimensionResource(id = R.dimen.corner_radius)))
            ),
        contentAlignment = Alignment.Center
    ) {
        Image(
            modifier = Modifier
                .fillMaxSize()
                .padding((dimensionResource(id = R.dimen.padding_small))),
            painter = painterResource(id = imageRes),
            contentDescription = null
        )
    }
}

@Preview
@Composable
private fun CustomItemPreview() {
    ProductImage(imageRes = R.drawable.bike2)
}
