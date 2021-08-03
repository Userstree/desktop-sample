package settings

import navigation.Component
import androidx.compose.runtime.Composable
import com.arkivanov.decompose.ComponentContext

class SettingsScreenComponent(
    private val componentContext: ComponentContext,
) : Component, ComponentContext by componentContext {

    @Composable
    override fun render() {
        SettingsScreen()
    }
}