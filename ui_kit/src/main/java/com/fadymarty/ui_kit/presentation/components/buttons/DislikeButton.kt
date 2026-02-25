package com.fadymarty.ui_kit.presentation.components.buttons

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.dropShadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.shadow.Shadow
import androidx.compose.ui.unit.DpOffset
import androidx.compose.ui.unit.dp
import com.fadymarty.ui_kit.common.theme.PropSwipePalette
import com.fadymarty.ui_kit.common.theme.PropSwipeTheme
import com.fadymarty.ui_kit.presentation.components.icons.PropSwipeIcons

@Composable
fun DislikeButton(
    modifier: Modifier = Modifier,
    swipeProgress: Float,
    onClick: () -> Unit,
) {
    Box(
        modifier = modifier
            .size(80.dp)
            .dropShadow(
                shape = CircleShape,
                shadow = Shadow(
                    offset = DpOffset(0.dp, 2.dp),
                    radius = 10.dp,
                    alpha = 0.2f
                )
            )
            .size(80.dp)
            .clip(CircleShape)
            .clickable(onClick = onClick)
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .dropShadow(
                    shape = CircleShape,
                    shadow = Shadow(
                        offset = DpOffset(0.dp, 2.dp),
                        radius = 10.dp,
                        alpha = 0.2f
                    )
                )
                .background(PropSwipeTheme.colorScheme.background),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                imageVector = PropSwipeIcons.Xmark,
                contentDescription = null,
                tint = Color.Unspecified
            )
        }
        Box(
            modifier = Modifier
                .alpha(-swipeProgress)
                .fillMaxSize()
                .border(
                    width = 2.dp,
                    brush = PropSwipeTheme.colorScheme.red,
                    shape = CircleShape
                )
                .background(PropSwipeTheme.colorScheme.red),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                imageVector = PropSwipeIcons.Xmark,
                contentDescription = null,
                tint = PropSwipePalette.White
            )
        }
    }
}