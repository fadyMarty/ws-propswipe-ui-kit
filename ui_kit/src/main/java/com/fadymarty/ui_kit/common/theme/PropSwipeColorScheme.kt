package com.fadymarty.ui_kit.common.theme

import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color

data class PropSwipeColorScheme(
    val green: Brush = PropSwipePalette.Green,
    val red: Brush = PropSwipePalette.Red,
    val primary: Color = PropSwipePalette.Primary,
    val grey: Color = PropSwipePalette.Grey,
    val onBackground: Color = PropSwipePalette.Black,
    val textDescription: Color = PropSwipePalette.TextDescription,
    val buttonBg: Color = PropSwipePalette.ButtonBg,
    val background: Color = PropSwipePalette.White,
)

val LocalPropSwipeColorScheme = staticCompositionLocalOf {
    PropSwipeColorScheme()
}