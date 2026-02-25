package com.fadymarty.ui_kit.presentation.components.card

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import com.fadymarty.ui_kit.common.util.format
import com.fadymarty.ui_kit.common.theme.PropSwipePalette
import com.fadymarty.ui_kit.common.theme.PropSwipeTheme
import com.fadymarty.ui_kit.common.theme.SfProDisplay
import com.fadymarty.ui_kit.presentation.components.icons.PropSwipeIcons

@Composable
fun PropertyCard(
    modifier: Modifier = Modifier,
    swipeProgress: Float,
    isOnTop: Boolean,
    price: Int,
    areaTotalM2: Float,
    rooms: Int,
    district: String,
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(580.dp)
            .clip(RoundedCornerShape(12.dp))
            .background(PropSwipeTheme.colorScheme.grey)
    ) {
        Column(
            modifier = Modifier.align(Alignment.BottomStart),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            Text(
                text = "${price.format()} ₽",
                style = TextStyle(
                    fontFamily = SfProDisplay,
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 44.sp,
                    lineHeight = 48.sp,
                    letterSpacing = (-0.01).em,
                    color = PropSwipePalette.White
                )
            )
            Row(
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                Row(
                    horizontalArrangement = Arrangement.spacedBy(8.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    PropertyChip(
                        label = "${areaTotalM2}м²",
                        icon = PropSwipeIcons.Crop
                    )
                    PropertyChip(
                        label = "$rooms комн",
                        icon = PropSwipeIcons.House
                    )
                }
            }
            PropertyChip(
                label = district,
                icon = PropSwipeIcons.MapPin
            )
        }
    }
}

@Composable
private fun PropertyChip(
    modifier: Modifier = Modifier,
    label: String,
    icon: ImageVector,
) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            modifier = Modifier.size(20.dp),
            imageVector = icon,
            contentDescription = null,
            tint = PropSwipePalette.White
        )
        Text(
            text = label,
            style = TextStyle(
                fontFamily = SfProDisplay,
                fontWeight = FontWeight.Medium,
                fontSize = 20.sp,
                lineHeight = 24.sp,
                letterSpacing = 0.em,
                color = PropSwipePalette.White
            )
        )
    }
}