package com.fadymarty.ui_kit.presentation.components.tab_bar

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.fadymarty.ui_kit.common.theme.PropSwipeTheme

@Composable
fun <T> TabBar(
    modifier: Modifier = Modifier,
    items: List<TabBarItem<T>>,
    onItemClick: (TabBarItem<T>) -> Unit,
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .height(74.dp)
            .background(PropSwipeTheme.colorScheme.background)
    ) {
        items.forEach { item ->
            Column(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxHeight()
                    .clickable(
                        interactionSource = null,
                        indication = null
                    ) {
                        onItemClick(item)
                    },
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Icon(
                    modifier = Modifier.size(28.dp),
                    imageVector = item.icon,
                    contentDescription = null,
                    tint = if (item.selected) {
                        PropSwipeTheme.colorScheme.primary
                    } else {
                        PropSwipeTheme.colorScheme.grey
                    }
                )
            }
        }
    }
}