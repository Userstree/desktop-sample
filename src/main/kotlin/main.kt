import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.MaterialTheme
import androidx.compose.ui.Modifier
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.WindowPlacement
import androidx.compose.ui.window.application
import androidx.compose.ui.window.rememberWindowState
import com.arkivanov.decompose.extensions.compose.jetbrains.rememberRootComponent
import navigation.NavHostComponent
import navigation.TopBar


fun main() = application {
    val state = rememberWindowState(placement = WindowPlacement.Maximized)
    Window(
        onCloseRequest = ::exitApplication,
        state = state,
        title = "zapis.kz",
    ) {
        MaterialTheme {
            val root = rememberRootComponent(factory = ::NavHostComponent)
            Column(Modifier.fillMaxSize()) {
                TopBar(Modifier.fillMaxWidth(), root)
                root.render()
            }
        }
    }
}