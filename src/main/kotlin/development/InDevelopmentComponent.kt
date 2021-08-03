package development

import androidx.compose.runtime.Composable
import com.arkivanov.decompose.ComponentContext
import navigation.Component

class InDevelopmentComponent(
    private val componentContext: ComponentContext,
) : Component, ComponentContext by componentContext {

    @Composable
    override fun render() {
        InDevelopmentScreen()
    }
}