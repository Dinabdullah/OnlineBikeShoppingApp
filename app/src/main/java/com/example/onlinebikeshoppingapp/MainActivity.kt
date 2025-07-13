package com.example.onlinebikeshoppingapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.onlinebikeshoppingapp.firstScreen.FirstScreen
import com.example.onlinebikeshoppingapp.thirdScreen.ThirdScreen
import com.example.onlinebikeshoppingapp.ui.theme.OnlineBikeShoppingAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            OnlineBikeShoppingAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { _ ->
                    ThirdScreen()
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    OnlineBikeShoppingAppTheme {

    }
}