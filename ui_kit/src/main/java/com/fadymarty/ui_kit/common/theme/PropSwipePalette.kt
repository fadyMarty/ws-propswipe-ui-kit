package com.fadymarty.ui_kit.common.theme

import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color

object PropSwipePalette {
    val Green = Brush.linearGradient(
        colors = listOf(Color(0xFF1FFF13), Color(0xFF00F874)),
        start = Offset(Float.POSITIVE_INFINITY, 0f),
        end = Offset(0f, Float.POSITIVE_INFINITY),
    )
    val Red = Brush.linearGradient(
        colors = listOf(Color(0xFFFF3030), Color(0xFFFF2764)),
        start = Offset(Float.POSITIVE_INFINITY, 0f),
        end = Offset(0f, Float.POSITIVE_INFINITY),
    )
    val Primary = Color(0xFFFBC107)
    val Grey = Color(0xFFC1C1C1)
    val Black = Color(0xFF252223)
    val TextDescription = Color(0xFF6D6A6B)
    val ButtonBg = Color(0xFFF5F5F5)
    val White = Color(0xFFFFFFFF)
}