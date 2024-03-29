package com.example.composelearning.ui.compositionLocal

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

class CompositionLocalActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppThemeContainer {
                AppScreen()
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun AppScreen() {
    val theme = LocalAppTheme.current
    val themeController = LocalAppThemeController.current
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .fillMaxSize()
            .background(theme.bgColor)
    ) {
        CustomButton(
            onClick = {
                themeController.toggle()
            },
            text = "Change App Theme"
        )
    }
}

@Composable
fun CustomButton(
    onClick: () -> Unit,
    text: String,
    modifier: Modifier = Modifier
) {
    val theme = LocalAppTheme.current
    Button(
        onClick = onClick,
        modifier = modifier,
        colors = ButtonDefaults.buttonColors(
            containerColor = theme.buttonColor
        )
    ) {
        Text(
            text = text
        )
    }
}