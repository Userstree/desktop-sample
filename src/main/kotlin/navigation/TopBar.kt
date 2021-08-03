package navigation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerMoveFilter
import com.arkivanov.decompose.extensions.compose.jetbrains.subscribeAsState

@Composable
fun TopBar(modifier: Modifier = Modifier, navHostComponent: NavHostComponent) {
    val navState by navHostComponent.router.state.subscribeAsState()
    val selectedTabIndex = when (navState.activeChild.configuration) {
        Screen.Home -> 0
        Screen.Logs -> 1
        is Screen.Staff -> 2
        is Screen.Client -> 3
        is Screen.Service -> 4
        is Screen.Statistics -> 5
        is Screen.Storage -> 6
        is Screen.Finance -> 7
        Screen.Settings -> 8
        is Screen.Help -> 9
        Screen.Profile -> 10
    }

    TabRow(selectedTabIndex, modifier) {

        listOf(
            Screen.Home,
            Screen.Logs,
            Screen.Staff.getTab(),
            Screen.Client.getTab(),
            Screen.Service.getTab(),
            Screen.Statistics.getTab(),
            Screen.Storage.getTab(),
            Screen.Finance.getTab(),
            Screen.Settings,
            Screen.Help.getTab(),
            Screen.Profile,
        ).forEach {
            when (it) {
                is Screen -> {

                    Tab(
                        selected = navState.activeChild.configuration == it,
                        onClick = {
                            navHostComponent.goToScreen(it)
                        },
                        modifier = Modifier.wrapContentSize(),
                        enabled = true,
                        text = {
                            Text(it.title)
                        },
                        icon = null
                    )
                }
                is TabWithPopup -> {
                    var active by remember { mutableStateOf(false) }
                    Box {
                        Tab(
                            selected = it.items.contains(navState.activeChild.configuration),
                            onClick = { },
                            modifier = Modifier.wrapContentSize().pointerMoveFilter(
                                onEnter = {
                                    active = true
                                    false
                                },
                                onExit = {
                                    active = false
                                    false
                                }
                            ),
                            enabled = true,
                            text = {
                                Text(it.title)
                            },
                            icon = null
                        )
                        DropdownMenu(
                            expanded = active,
                            onDismissRequest = { active = false }
                        ) {
                            it.items.forEach { screen ->
                                DropdownMenuItem({
                                    navHostComponent.goToScreen(screen)
                                    active = false
                                }) {
                                    Text(
                                        text = screen.title,
                                        color = if (navState.activeChild.configuration == screen) Color.Red else Color.Unspecified
                                    )
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}

