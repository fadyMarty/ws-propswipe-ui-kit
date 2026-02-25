package com.fadymarty.ui_kit.presentation.components.buttons

import androidx.compose.foundation.layout.width
import androidx.compose.material3.ButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.unit.dp
import com.fadymarty.ui_kit.common.theme.PropSwipeColorScheme
import com.fadymarty.ui_kit.common.theme.PropSwipeTheme

@Composable
fun SmallButton(
    modifier: Modifier = Modifier,
    label: String,
    onClick: () -> Unit,
    enabled: Boolean = true,
) {
    PropSwipeButton(
        modifier = modifier.width(112.dp),
        label = label,
        onClick = onClick,
        enabled = enabled,
        colors = ButtonDefaults.buttonColors(
            containerColor = PropSwipeTheme.colorScheme.buttonBg,
            contentColor = PropSwipeTheme.colorScheme.onBackground,
            disabledContainerColor = PropSwipeTheme.colorScheme.buttonBg.copy(alpha = 0.5f),
            disabledContentColor = PropSwipeTheme.colorScheme.onBackground.copy(alpha = 0.5f)
        )
    )
}
