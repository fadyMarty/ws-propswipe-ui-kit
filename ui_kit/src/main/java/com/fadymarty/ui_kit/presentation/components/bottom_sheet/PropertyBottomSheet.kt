package com.fadymarty.ui_kit.presentation.components.bottom_sheet

import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import com.fadymarty.ui_kit.common.util.format
import com.fadymarty.ui_kit.common.theme.PropSwipeTheme
import com.fadymarty.ui_kit.common.theme.SfProDisplay
import com.fadymarty.ui_kit.presentation.components.buttons.ButtonWithIcon
import com.fadymarty.ui_kit.presentation.components.icons.PropSwipeIcons

@Composable
fun PropertyBottomSheet(
    modifier: Modifier = Modifier,
    isExpanded: Boolean,
    onClick: () -> Unit,
    price: Int,
    address: String,
    areaTotalM2: Float,
    rooms: Int,
    floor: Int,
    district: String,
    yearBuilt: Int,
) {
    val density = LocalDensity.current
    val topPadding = with(density) {
        WindowInsets.statusBars.getTop(density).toDp()
    }
    val animatedTopPadding by animateDpAsState(
        targetValue = if (isExpanded) {
            topPadding + 78.dp
        } else 32.dp
    )
    val animatedCornerSize by animateDpAsState(
        targetValue = if (isExpanded) 0.dp else 24.dp
    )

    Column(
        modifier = modifier
            .clip(RoundedCornerShape(animatedCornerSize))
            .background(PropSwipeTheme.colorScheme.background)
            .clickable(
                interactionSource = null,
                indication = null,
                onClick = onClick
            )
            .padding(top = animatedTopPadding)
            .padding(horizontal = 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "${price.format()} ₽",
            style = TextStyle(
                fontFamily = SfProDisplay,
                fontWeight = FontWeight.Medium,
                fontSize = 32.sp,
                lineHeight = 40.sp,
                letterSpacing = 0.em
            )
        )
        Spacer(Modifier.height(4.dp))
        Text(
            text = address,
            style = TextStyle(
                fontFamily = SfProDisplay,
                fontWeight = FontWeight.Normal,
                fontSize = 20.sp,
                lineHeight = 24.sp,
                letterSpacing = 0.em,
                color = PropSwipeTheme.colorScheme.textDescription,
                textAlign = TextAlign.Center
            )
        )
        Spacer(Modifier.height(32.dp))
        FlowRow(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(6.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            ButtonWithIcon(
                label = "${areaTotalM2}м²",
                icon = PropSwipeIcons.Crop
            )
            ButtonWithIcon(
                label = "$rooms комнаты",
                icon = PropSwipeIcons.House
            )
            ButtonWithIcon(
                label = "$floor этаж",
                icon = PropSwipeIcons.Layers
            )
            ButtonWithIcon(
                label = district,
                icon = PropSwipeIcons.MapPin
            )
            ButtonWithIcon(
                label = "$yearBuilt г.",
                icon = PropSwipeIcons.Calendar
            )
        }
    }
}