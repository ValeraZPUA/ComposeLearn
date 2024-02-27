package com.example.composelearning.ui.compositionLocal

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.ProvidableCompositionLocal
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.composelearning.controller.compositionLocal.AppThemeController
import com.example.composelearning.controller.compositionLocal.EmptyThemeController
import com.example.composelearning.controller.compositionLocal.RealThemeController
import com.example.composelearning.data.compositionLocal.AppTheme
import com.example.composelearning.data.compositionLocal.SharedPreferencesThemeDataSource

val LocalAppTheme = compositionLocalOf {
    AppTheme.Light
}

val LocalAppThemeController: ProvidableCompositionLocal<AppThemeController> = staticCompositionLocalOf {
    EmptyThemeController
}

@Composable
fun AppThemeContainer(content: @Composable () -> Unit) {
    val context = LocalContext.current
    val themeDataSource = remember {
        SharedPreferencesThemeDataSource(context)
    }
    val controller = remember {
        RealThemeController(themeDataSource)
    }
    val theme by themeDataSource.themeStateFlow.collectAsStateWithLifecycle()
    CompositionLocalProvider(
        LocalAppTheme provides theme,
        LocalAppThemeController provides controller
    ) {
        content()
    }
}