package com.github.gihxs.nutriva_mvp.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable

private val NutrivaColorScheme = lightColorScheme(
    primary = NutrivaDarkBlue,
    onPrimary = NutrivaCardBackground,
    secondary = NutrivaTeal,
    onSecondary = NutrivaCardBackground,
    background = NutrivaBackground,
    onBackground = NutrivaDarkBlue,
    surface = NutrivaCardBackground,
    onSurface = NutrivaDarkBlue,
    surfaceVariant = NutrivaTealLight,
    onSurfaceVariant = NutrivaTextSecondary,
    outline = NutrivaOutline,
    outlineVariant = NutrivaOutlineVariant,
    error = NutrivaError,
    onError = NutrivaCardBackground,
    surfaceContainerHighest = NutrivaCardBackground

)

@Composable
fun NutrivamvpTheme(content: @Composable () -> Unit) {
    MaterialTheme(
        colorScheme = NutrivaColorScheme,
        typography = NutrivamvpTypography,
        shapes = NutrivamvpShapes,
        content = content
    )
}
