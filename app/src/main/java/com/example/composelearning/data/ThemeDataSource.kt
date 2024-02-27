package com.example.composelearning.data

import kotlinx.coroutines.flow.StateFlow

interface ThemeDataSource {

    val themeStateFlow: StateFlow<AppTheme>

    fun setTheme(theme: AppTheme)

}