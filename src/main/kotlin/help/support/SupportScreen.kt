package help.support

import Footer
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun SupportScreen() {
    val scrollState = rememberScrollState()
    Column(
        modifier = Modifier.wrapContentHeight().fillMaxWidth().verticalScroll(scrollState)
    ) {
        Row(modifier = Modifier.fillMaxWidth()) {
            Column(modifier = Modifier.weight(1f)) {

            }
            Column(modifier = Modifier.weight(1f)) {

            }
        }
        Footer()
    }
}