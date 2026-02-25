package com.fadymarty.propswipe_ui_kit

import android.graphics.Color
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.SystemBarStyle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import com.fadymarty.ui_kit.common.theme.PropSwipeTheme
import com.fadymarty.ui_kit.common.theme.SfProDisplay
import com.fadymarty.ui_kit.presentation.components.bottom_sheet.PropertyBottomSheet
import com.fadymarty.ui_kit.presentation.components.buttons.DislikeButton
import com.fadymarty.ui_kit.presentation.components.buttons.LikeButton
import com.fadymarty.ui_kit.presentation.components.buttons.PropSwipeButton
import com.fadymarty.ui_kit.presentation.components.buttons.SmallButton
import com.fadymarty.ui_kit.presentation.components.card.PropertyCard
import com.fadymarty.ui_kit.presentation.components.dialog.ConfirmDialog
import com.fadymarty.ui_kit.presentation.components.icons.PropSwipeIcons
import com.fadymarty.ui_kit.presentation.components.input.Input
import com.fadymarty.ui_kit.presentation.components.tab_bar.TabBar
import com.fadymarty.ui_kit.presentation.components.tab_bar.TabBarItem
import com.fadymarty.ui_kit.presentation.components.toolbar.Toolbar

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge(
            statusBarStyle = SystemBarStyle.light(
                scrim = Color.TRANSPARENT,
                darkScrim = Color.TRANSPARENT
            )
        )
        setContent {
            PropSwipeTheme {
                var isDialogVisible by rememberSaveable {
                    mutableStateOf(false)
                }

                Scaffold(
                    containerColor = androidx.compose.ui.graphics.Color(0xFFD8D8D8)
                ) { innerPadding ->
                    LazyColumn(
                        modifier = Modifier.fillMaxSize(),
                        contentPadding = PaddingValues(
                            start = 16.dp,
                            top = innerPadding.calculateTopPadding() + 64.dp,
                            end = 16.dp,
                            bottom = innerPadding.calculateBottomPadding() + 64.dp
                        ),
                        verticalArrangement = Arrangement.spacedBy(64.dp)
                    ) {
                        item {
                            ComponentPreview(
                                title = "TabBar"
                            ) {
                                TabBar(
                                    items = listOf(
                                        TabBarItem(
                                            selected = true,
                                            icon = PropSwipeIcons.Home,
                                            route = Route.Home
                                        ),
                                        TabBarItem(
                                            selected = false,
                                            icon = PropSwipeIcons.Heart,
                                            route = Route.Favorites
                                        )
                                    ),
                                    onItemClick = {}
                                )
                                TabBar(
                                    items = listOf(
                                        TabBarItem(
                                            selected = false,
                                            icon = PropSwipeIcons.Home,
                                            route = Route.Home
                                        ),
                                        TabBarItem(
                                            selected = true,
                                            icon = PropSwipeIcons.Heart,
                                            route = Route.Favorites
                                        )
                                    ),
                                    onItemClick = {}
                                )
                            }
                        }
                        item {
                            ComponentPreview(
                                title = "Input"
                            ) {
                                Input(
                                    modifier = Modifier.fillMaxWidth(),
                                    value = "",
                                    onValueChange = {},
                                    onClearClick = {},
                                    hint = "Поиск...",
                                    keyboardOptions = KeyboardOptions(
                                        imeAction = ImeAction.Search
                                    )
                                )
                                Input(
                                    modifier = Modifier.fillMaxWidth(),
                                    value = "Квартира",
                                    onValueChange = {},
                                    onClearClick = {},
                                    hint = "Поиск...",
                                    keyboardOptions = KeyboardOptions(
                                        imeAction = ImeAction.Search
                                    )
                                )
                            }
                        }
                        item {
                            ComponentPreview(
                                title = "Dialog"
                            ) {
                                PropSwipeButton(
                                    modifier = Modifier.align(Alignment.CenterHorizontally),
                                    label = "Показать диалог",
                                    onClick = {
                                        isDialogVisible = true
                                    }
                                )
                            }
                        }
                        item {
                            ComponentPreview(
                                title = "Кнопки"
                            ) {
                                PropSwipeButton(
                                    label = "Смотреть объекты",
                                    onClick = {}
                                )
                                SmallButton(
                                    label = "Готово",
                                    onClick = {}
                                )
                                SmallButton(
                                    label = "Изменить",
                                    onClick = {},
                                    enabled = false
                                )
                                Row(
                                    horizontalArrangement = Arrangement.spacedBy(24.dp)
                                ) {
                                    DislikeButton(
                                        swipeProgress = -1f,
                                        onClick = {}
                                    )
                                    DislikeButton(
                                        swipeProgress = 0f,
                                        onClick = {}
                                    )
                                }
                                Row(
                                    horizontalArrangement = Arrangement.spacedBy(24.dp)
                                ) {
                                    LikeButton(
                                        swipeProgress = 1f,
                                        onClick = {}
                                    )
                                    LikeButton(
                                        swipeProgress = 0f,
                                        onClick = {}
                                    )
                                }
                            }
                        }
                        item {
                            ComponentPreview(
                                title = "Bottom Sheet"
                            ) {
                                PropertyBottomSheet(
                                    modifier = Modifier.height(500.dp),
                                    isExpanded = false,
                                    onClick = {},
                                    price = 14000000,
                                    address = "ул. Ангелов, д.7",
                                    areaTotalM2 = 120f,
                                    rooms = 2,
                                    floor = 8,
                                    district = "Смоленская",
                                    yearBuilt = 2019
                                )
                            }
                        }
                        item {
                            ComponentPreview(
                                title = "Toolbar"
                            ) {
                                Toolbar(
                                    isEditing = false,
                                    value = "",
                                    likesCount = 2,
                                    onValueChange = {},
                                    onClearClick = {},
                                    onEditClick = {}
                                )
                                Toolbar(
                                    isEditing = true,
                                    value = "",
                                    likesCount = 2,
                                    onValueChange = {},
                                    onClearClick = {},
                                    onEditClick = {}
                                )
                                Toolbar(
                                    isEditing = false,
                                    value = "",
                                    likesCount = 0,
                                    onValueChange = {},
                                    onClearClick = {},
                                    onEditClick = {}
                                )
                            }
                        }
                        item {
                            ComponentPreview(
                                title = "Карточки"
                            ) {
                                PropertyCard(
                                    swipeProgress = 0f,
                                    isOnTop = true,
                                    price = 140000000,
                                    areaTotalM2 = 120f,
                                    rooms = 2,
                                    district = "Смоленская"
                                )
                            }
                        }
                    }
                }

                if (isDialogVisible) {
                    ConfirmDialog(
                        onDismissRequest = {
                            isDialogVisible = false
                        },
                        onDeleteClick = {
                            isDialogVisible = false
                        }
                    )
                }
            }
        }
    }
}

@Composable
private fun ComponentPreview(
    title: String,
    content: @Composable ColumnScope.() -> Unit,
) {
    Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(24.dp)
    ) {
        Text(
            text = title,
            style = TextStyle(
                fontFamily = SfProDisplay,
                fontWeight = FontWeight.Medium,
                fontSize = 32.sp,
                lineHeight = 40.sp,
                letterSpacing = 0.em
            )
        )
        content()
    }
}

private sealed interface Route {
    data object Home : Route
    data object Favorites : Route
}