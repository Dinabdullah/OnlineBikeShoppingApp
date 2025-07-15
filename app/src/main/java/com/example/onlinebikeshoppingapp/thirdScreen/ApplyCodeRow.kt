package com.example.onlinebikeshoppingapp.thirdScreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.onlinebikeshoppingapp.R

@Composable
fun ApplyCodeRow(
    modifier: Modifier =Modifier,
    onClick: (applyCode: String) -> Unit
) {
    var applyCode by remember { mutableStateOf("") }
    Row(
        modifier = modifier
            .padding(horizontal = 20.dp, vertical = 16.dp)
            .width(350.dp)
            .height(44.dp)
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
        horizontalArrangement = Arrangement.End,
        verticalAlignment = Alignment.CenterVertically
    ) {
        androidx.compose.foundation.text.BasicTextField(
            value = applyCode,
            onValueChange = {applyCode=it},
            singleLine = true,
            modifier = Modifier
                .weight(1f)
                .padding(start = 12.dp, end = 8.dp),
            decorationBox = { innerTextField ->
                if ("".isEmpty()) {
                    Text(
                        text = "",
                        color = Color.Gray
                    )
                }
                innerTextField()
            }
        )
        Button(
            modifier = modifier
                .width(114.dp)
                .height(44.dp)
                .background(
                    brush = Brush.linearGradient(
                        colors = listOf(
                            Color(0xFF34C8E8),
                            Color(0xFF4E4AF2)
                        )
                    )
                ),
            onClick = { onClick(applyCode) },
            shape = RoundedCornerShape(10.dp),
        ) {
            Text("Apply")
        }

    }
}

@Preview
@Composable
private fun ApplyCodeRowPreview() {
    ApplyCodeRow(){}
}