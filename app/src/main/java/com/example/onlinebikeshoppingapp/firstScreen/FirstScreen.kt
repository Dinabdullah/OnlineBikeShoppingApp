package com.example.onlinebikeshoppingapp.firstScreen

import CustomSquare
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.onlinebikeshoppingapp.R

@Composable
fun FirstScreen(modifier: Modifier = Modifier) {
    val items = listOf(
        DataTypes.Text(R.string.all),
        DataTypes.Image(R.drawable.bolt_batteryblock),
        DataTypes.Image(R.drawable.road),
        DataTypes.Image(R.drawable.union),
        DataTypes.Image(R.drawable.union__1_)
    )

    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        items.forEachIndexed { index, data ->
            CustomSquare(
                data = data,
                modifier = Modifier.padding(bottom = (index * 10).dp, start = 10.dp )
            )
        }
    }
}


@Preview
@Composable
private fun FirstScreenPreview() {
    FirstScreen()
}