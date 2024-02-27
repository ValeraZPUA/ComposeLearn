package com.example.composelearning.data.compositionLocal

import android.content.Context
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import kotlinx.coroutines.flow.MutableStateFlow

class SharedPreferencesThemeDataSource(
    context: Context
) : ThemeDataSource {

    private val preferences = context.getSharedPreferences(
        THEME_PREFERENCES_NAME, Context.MODE_PRIVATE
    )

    override val themeStateFlow: MutableStateFlow<AppTheme> = MutableStateFlow(readTheme())

    override fun setTheme(theme: AppTheme) {
        preferences.edit()
            .putInt(KEY_BUTTON_COLOR, theme.buttonColor.toArgb())
            .putInt(KEY_BG_COLOR, theme.bgColor.toArgb())
            .apply()
        themeStateFlow.value = theme
    }

    private fun readTheme(): AppTheme {
        if (!hasSaveTheme()) return AppTheme.Light
        return AppTheme(
            buttonColor = Color(preferences.getInt(KEY_BUTTON_COLOR, 0)),
            bgColor = Color(preferences.getInt(KEY_BG_COLOR, 0))
        )
    }

    private fun hasSaveTheme() = preferences.contains(KEY_BG_COLOR)

    private companion object {
        const val THEME_PREFERENCES_NAME = "themes"
        const val KEY_BUTTON_COLOR = "BUTTON_COLOR"
        const val KEY_BG_COLOR = "BG_COLOR"
    }
}