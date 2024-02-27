package com.example.composelearning.controller

import com.example.composelearning.data.AppTheme
import com.example.composelearning.data.ThemeDataSource

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