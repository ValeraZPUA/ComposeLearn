package com.example.composelearning.data.compositionLocal

import androidx.compose.ui.graphics.Color

data class AppTheme(
    val buttonColor: Color,
    val bgColor: Color
) {

    companion object {
        val Light = AppTheme(
            buttonColor = Color.Blue,
            bgColor = Color.White
        )

        val Dark = AppTheme(
            buttonColor = Color.Gray,
            bgColor = Color.Black
        )
    }

}