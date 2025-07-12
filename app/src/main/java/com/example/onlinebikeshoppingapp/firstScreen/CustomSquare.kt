import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.onlinebikeshoppingapp.firstScreen.DataTypes
import com.example.onlinebikeshoppingapp.R

@Composable
fun CustomSquare(
    modifier: Modifier = Modifier,
    data: DataTypes
) {
    Box(
        modifier = modifier
            .padding(4.dp)
            .width(50.dp)
            .height(50.dp)
            .background(
                brush = Brush.linearGradient(
                    colors = listOf(
                        Color(0xFF353F54),
                        Color(0xFF222834)
                    )
                ),
                shape = RoundedCornerShape(8.dp)
            )
    ) {
        when (data) {
            is DataTypes.Image -> {
                Image(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(6.dp),
                    painter = painterResource(id = data.image),
                    contentDescription = null
                )
            }

            is DataTypes.Text -> {
                Text(
                    text = stringResource(id = data.text),
                    color = Color.White,
                    modifier = Modifier
                        .padding(6.dp)
                        .align(Alignment.Center)
                )
            }
        }
    }
}

@Preview
@Composable
private fun SquarePreview() {
    CustomSquare(data = DataTypes.Image(R.drawable.bolt_batteryblock))
}