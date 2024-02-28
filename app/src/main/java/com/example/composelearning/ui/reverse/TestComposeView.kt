package com.example.composelearning.ui.reverse

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun JustText(text: String) {
    Text(
        text = text
    )
}

@Preview
@Composable
fun JustTextPreview() {
    JustText(text = "some text")
}