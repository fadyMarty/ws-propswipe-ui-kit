package com.fadymarty.ui_kit.presentation.components.tab_bar

import androidx.compose.ui.graphics.vector.ImageVector

data class TabBarItem<T>(
    val selected: Boolean,
    val icon: ImageVector,
    val route: T,
)
