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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.onlinebikeshoppingapp.R

@Composable
fun ApplyCodeRow(
    modifier: Modifier = Modifier,
    onClick: (applyCode: String) -> Unit
) {
    var applyCode by remember { mutableStateOf("") }
    Row(
        modifier = modifier
            .padding(
                horizontal = dimensionResource(id = R.dimen.dp_20),
                vertical = dimensionResource(id = R.dimen.dp_12)
            )
            .width(dimensionResource(id = R.dimen.dp_350))
            .height(dimensionResource(id = R.dimen.dp_44))
            .shadow(
                elevation = 4.dp,
                shape = RoundedCornerShape(dimensionResource(id = R.dimen.dp_8)),
                ambientColor = colorResource(id = R.color.card_background),
                spotColor = colorResource(id = R.color.card_background)
            )
            .clip(RoundedCornerShape(dimensionResource(id = R.dimen.dp_8)))
            .background(
                color = colorResource(id = R.color.counter_background),
                shape = RoundedCornerShape(dimensionResource(id = R.dimen.dp_8))
            ),
        horizontalArrangement = Arrangement.End,
        verticalAlignment = Alignment.CenterVertically
    ) {
        androidx.compose.foundation.text.BasicTextField(
            value = applyCode,
            onValueChange = { applyCode = it },
            singleLine = true,
            modifier = Modifier
                .weight(1f)
                .padding(
                    start = dimensionResource(id = R.dimen.dp_12),
                    end = dimensionResource(id = R.dimen.dp_8)
                ),
            textStyle = TextStyle(color = Color.Gray)
        )
        Button(
            modifier = modifier
                .width(dimensionResource(id = R.dimen.dp_114))
                .height(dimensionResource(id = R.dimen.dp_44))
                .gradientBackground(),
            onClick = { onClick(applyCode) },
            shape = RoundedCornerShape(dimensionResource(id = R.dimen.dp_10)),
        ) {
            Text(stringResource(R.string.apply))
        }

    }
}

@Preview
@Composable
private fun ApplyCodeRowPreview() {
    ApplyCodeRow() {}
}