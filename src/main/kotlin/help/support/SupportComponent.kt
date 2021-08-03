package help.support

import androidx.compose.runtime.Composable
import com.arkivanov.decompose.ComponentContext
import navigation.Component

class SupportComponent(
    private val componentContext: ComponentContext,
) : Component, ComponentContext by componentContext {

    @Composable
    override fun render() {
        SupportScreen()
    }
}