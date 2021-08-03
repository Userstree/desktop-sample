package home

import navigation.Component
import HomeScreen
import androidx.compose.runtime.Composable
import com.arkivanov.decompose.ComponentContext

class HomeScreenComponent(
    private val componentContext: ComponentContext,
) : Component, ComponentContext by componentContext {

    @Composable
    override fun render() {
        HomeScreen()
    }
}