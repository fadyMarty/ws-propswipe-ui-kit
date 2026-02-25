package com.fadymarty.ui_kit.presentation.components.toolbar

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.Crossfade
import androidx.compose.animation.core.EaseOut
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import com.fadymarty.ui_kit.common.theme.PropSwipeTheme
import com.fadymarty.ui_kit.common.theme.SfProDisplay
import com.fadymarty.ui_kit.presentation.components.buttons.SmallButton
import com.fadymarty.ui_kit.presentation.components.input.Input

@Composable
fun Toolbar(
    modifier: Modifier = Modifier,
    isEditing: Boolean,
    value: String,
    likesCount: Int,
    onValueChange: (String) -> Unit,
    onClearClick: () -> Unit,
    onEditClick: () -> Unit,
) {
    Column(
        modifier = modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(20.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(5.dp, Alignment.End),
            verticalAlignment = Alignment.CenterVertically
        ) {
            AnimatedVisibility(
                modifier = Modifier.weight(1f),
                visible = likesCount > 0,
                enter = fadeIn(tween(easing = EaseOut)),
                exit = fadeOut(tween(easing = EaseOut)),
            ) {
                Input(
                    value = value,
                    onValueChange = onValueChange,
                    onClearClick = onClearClick,
                    hint = "Поиск..."
                )
            }
            Crossfade(
                targetState = isEditing,
                animationSpec = tween(easing = EaseOut)
            ) { isEditing ->
                if (isEditing) {
                    SmallButton(
                        label = "Готово",
                        onClick = onEditClick
                    )
                } else {
                    SmallButton(
                        label = "Изменить",
                        onClick = onEditClick,
                        enabled = likesCount > 0
                    )
                }
            }
        }
        Row(
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Лайки",
                style = TextStyle(
                    fontFamily = SfProDisplay,
                    fontWeight = FontWeight.Medium,
                    fontSize = 28.sp,
                    lineHeight = 32.sp,
                    letterSpacing = 0.em
                )
            )
            AnimatedVisibility(
                visible = likesCount > 0,
                enter = fadeIn(tween(easing = EaseOut)),
                exit = fadeOut(tween(easing = EaseOut)),
            ) {
                Box(
                    modifier = Modifier
                        .clip(CircleShape)
                        .background(PropSwipeTheme.colorScheme.buttonBg)
                        .padding(
                            horizontal = 9.dp,
                            vertical = 4.dp
                        )
                ) {
                    Crossfade(
                        targetState = likesCount,
                        animationSpec = tween(easing = EaseOut)
                    ) { likesCount ->
                        Text(
                            text = likesCount.toString(),
                            style = TextStyle(
                                fontFamily = SfProDisplay,
                                fontWeight = FontWeight.Medium,
                                fontSize = 16.sp,
                                lineHeight = 20.sp,
                                letterSpacing = 0.em
                            )
                        )
                    }
                }
            }
        }
    }
}