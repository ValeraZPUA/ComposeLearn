package com.example.composelearning.controller.compositionLocal

import com.example.composelearning.data.compositionLocal.AppTheme
import com.example.composelearning.data.compositionLocal.ThemeDataSource

class RealThemeController(
    private val themeDataSource: ThemeDataSource
) : AppThemeController {

    override fun toggle() {
        val currentTheme = themeDataSource.themeStateFlow.value
        if (currentTheme == AppTheme.Dark) {
            themeDataSource.setTheme(AppTheme.Light)
        } else {
            themeDataSource.setTheme(AppTheme.Dark)
        }
    }

}