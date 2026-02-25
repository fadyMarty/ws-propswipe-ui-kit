package com.fadymarty.ui_kit.common.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider

@Composable
fun PropSwipeTheme(
    content: @Composable () -> Unit,
) {
    val colorScheme = PropSwipeColorScheme()

    CompositionLocalProvider(
        LocalPropSwipeColorScheme provides colorScheme
    ) {
        MaterialTheme(
            colorScheme = lightColorScheme(
                primary = colorScheme.primary,
                onBackground = colorScheme.onBackground,
                background = colorScheme.background
            ),
            content = content
        )
    }
}

object PropSwipeTheme {

    val colorScheme: PropSwipeColorScheme
        @Composable
        get() = LocalPropSwipeColorScheme.current
}