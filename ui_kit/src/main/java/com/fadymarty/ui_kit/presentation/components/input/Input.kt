package com.fadymarty.ui_kit.presentation.components.input

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.EaseOut
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.ripple
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import com.fadymarty.ui_kit.common.theme.PropSwipeTheme
import com.fadymarty.ui_kit.common.theme.SfProDisplay
import com.fadymarty.ui_kit.presentation.components.icons.PropSwipeIcons

@Composable
fun Input(
    modifier: Modifier = Modifier,
    value: String,
    onValueChange: (String) -> Unit,
    onClearClick: () -> Unit,
    hint: String? = null,
    singleLine: Boolean = true,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    keyboardActions: KeyboardActions = KeyboardActions.Default,
) {
    BasicTextField(
        modifier = modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(20.dp))
            .background(PropSwipeTheme.colorScheme.buttonBg)
            .padding(12.dp),
        value = value,
        onValueChange = onValueChange,
        keyboardOptions = keyboardOptions,
        keyboardActions = keyboardActions,
        singleLine = singleLine,
        cursorBrush = SolidColor(PropSwipeTheme.colorScheme.primary),
        textStyle = TextStyle(
            fontFamily = SfProDisplay,
            fontWeight = FontWeight.Medium,
            fontSize = 16.sp,
            lineHeight = 20.sp,
            letterSpacing = 0.em,
            color = PropSwipeTheme.colorScheme.onBackground
        )
    ) { innerTextField ->
        Row(
            modifier = Modifier.fillMaxWidth()
        ) {
            Box(
                modifier = Modifier.weight(1f)
            ) {
                if (value.isEmpty() && hint != null) {
                    Text(
                        text = hint,
                        style = TextStyle(
                            fontFamily = SfProDisplay,
                            fontWeight = FontWeight.Medium,
                            fontSize = 16.sp,
                            lineHeight = 20.sp,
                            letterSpacing = 0.em,
                            color = PropSwipeTheme.colorScheme.textDescription
                        )
                    )
                }
                innerTextField()
            }
            AnimatedVisibility(
                visible = value.isNotEmpty(),
                enter = fadeIn(tween(easing = EaseOut)),
                exit = fadeOut(tween(easing = EaseOut)),
            ) {
                Icon(
                    modifier = Modifier
                        .size(20.dp)
                        .clickable(
                            interactionSource = remember { MutableInteractionSource() },
                            indication = ripple(bounded = false),
                            onClick = onClearClick
                        ),
                    imageVector = PropSwipeIcons.Xmark,
                    contentDescription = null,
                    tint = PropSwipeTheme.colorScheme.textDescription
                )
            }
        }
    }
}