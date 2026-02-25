package com.fadymarty.ui_kit.presentation.components.dialog

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import com.fadymarty.ui_kit.common.theme.PropSwipeTheme
import com.fadymarty.ui_kit.common.theme.SfProDisplay
import com.fadymarty.ui_kit.presentation.components.buttons.PropSwipeButton

@Composable
fun ConfirmDialog(
    onDismissRequest: () -> Unit,
    onDeleteClick: () -> Unit,
) {
    Dialog(
        onDismissRequest = onDismissRequest
    ) {
        Column(
            modifier = Modifier
                .width(255.dp)
                .clip(RoundedCornerShape(24.dp))
                .background(PropSwipeTheme.colorScheme.background)
                .padding(horizontal = 16.dp)
                .padding(
                    top = 20.dp,
                    bottom = 16.dp
                ),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(20.dp)
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Text(
                    text = "Удалить объект?",
                    style = TextStyle(
                        fontFamily = SfProDisplay,
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 16.sp,
                        lineHeight = 20.sp,
                        letterSpacing = (-0.02).em
                    )
                )
                Text(
                    text = "Вы уверены, что хотите удалить объект?",
                    style = TextStyle(
                        fontFamily = SfProDisplay,
                        fontWeight = FontWeight.Normal,
                        fontSize = 14.sp,
                        lineHeight = 18.sp,
                        letterSpacing = (-0.01).em,
                        textAlign = TextAlign.Center,
                        color = PropSwipeTheme.colorScheme.textDescription
                    )
                )
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(6.dp)
                ) {
                    PropSwipeButton(
                        modifier = Modifier.weight(1f),
                        label = "Назад",
                        onClick = onDismissRequest,
                        colors = ButtonDefaults.buttonColors(
                            containerColor = PropSwipeTheme.colorScheme.buttonBg,
                            contentColor = PropSwipeTheme.colorScheme.onBackground
                        )
                    )
                    PropSwipeButton(
                        modifier = Modifier.weight(1f),
                        label = "Удалить",
                        onClick = onDeleteClick
                    )
                }
            }
        }
    }
}