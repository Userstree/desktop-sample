package navigation

import androidx.compose.runtime.Composable
import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.extensions.compose.jetbrains.Children
import com.arkivanov.decompose.pop
import com.arkivanov.decompose.push
import com.arkivanov.decompose.router
import development.InDevelopmentComponent
import help.support.SupportComponent
import home.HomeScreenComponent
import profile.ProfileComponent
import settings.SettingsScreenComponent

/**
 * Navigator
 */
class NavHostComponent(
    componentContext: ComponentContext
) : Component, ComponentContext by componentContext {

    val router = router<Screen, Component>(
        initialConfiguration = Screen.Home,
        childFactory = ::createScreenComponent
    )

    /**
     * Factory function to create screen from given ScreenConfig
     */
    private fun createScreenComponent(
        screen: Screen,
        componentContext: ComponentContext
    ): Component {
        return when (screen) {
            is Screen.Home -> HomeScreenComponent(componentContext)
            is Screen.Settings -> SettingsScreenComponent(componentContext)
            is Screen.Help.Support -> SupportComponent(componentContext)
            is Screen.Profile -> ProfileComponent(componentContext)
            else -> InDevelopmentComponent(componentContext)
        }
    }


    /**
     * Invoked when `GO` button clicked (InputScreen)
     */
    fun goToScreen(screen: Screen) {
        router.push(screen)
    }

    /**
     * Invoked when `GO BACK` button clicked (GreetingScreen)
     */
    fun goBack() {
        router.pop()
    }


    /**
     * Renders screen as per request
     */
    @Composable
    override fun render() {
        Children(routerState = router.state) {
            it.instance.render()
        }
    }
}