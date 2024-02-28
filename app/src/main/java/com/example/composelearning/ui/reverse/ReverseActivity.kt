package com.example.composelearning.ui.reverse

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent

class ReverseActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JustText(text = "ololo")
        }
    }
}