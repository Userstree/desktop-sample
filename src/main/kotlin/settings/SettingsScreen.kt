package settings

import Footer
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import gray

@Composable
fun SettingsScreen() {
    val scrollState = rememberScrollState()

    Column(
        modifier = Modifier.wrapContentHeight().fillMaxWidth().verticalScroll(scrollState)
    ) {
        Row(modifier = Modifier.fillMaxWidth()) {
            Column(modifier = Modifier.weight(1f)) {
                MainSettings()
            }
            Column(modifier = Modifier.weight(1f)) {
                LogsSettings()
            }
        }
        Footer()
    }
}

@Composable
fun MainSettings() {
    Column(Modifier.fillMaxWidth().padding(16.dp).background(gray, RoundedCornerShape(4.dp))) {
        Text("Main Settings", modifier = Modifier.padding(16.dp))
        val modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp)
        Column(Modifier.padding(8.dp)) {
            Divider(Modifier, Color.Gray, thickness = 1.dp, startIndent = 16.dp)
            Text("Firm", modifier)
            Divider(Modifier, Color.Gray, thickness = 1.dp, startIndent = 16.dp)
            Text("Billing", modifier)
            Divider(Modifier, Color.Gray, thickness = 1.dp, startIndent = 16.dp)
            Text("Sms settings", modifier)
            Divider(Modifier, Color.Gray, thickness = 1.dp, startIndent = 16.dp)
            Text("Rights", modifier)
            Divider(Modifier, Color.Gray, thickness = 1.dp, startIndent = 16.dp)
            Text("Your website's widget", modifier)
            Divider(Modifier, Color.Gray, thickness = 1.dp, startIndent = 16.dp)
            Text("Contracts", modifier)
        }
    }
}

@Composable
fun LogsSettings() {
    Column(Modifier.fillMaxWidth().padding(16.dp).background(gray, RoundedCornerShape(4.dp))) {
        Text("Logs Settings", modifier = Modifier.padding(16.dp))
        val modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp)
        Column(Modifier.padding(8.dp)) {
            Divider(Modifier, Color.Gray, thickness = 1.dp, startIndent = 16.dp)
            Text("Logs", modifier)
            Divider(Modifier, Color.Gray, thickness = 1.dp, startIndent = 16.dp)
            Text("Working places", modifier)
            Divider(Modifier, Color.Gray, thickness = 1.dp, startIndent = 16.dp)
            Text("Sources", modifier)
            Divider(Modifier, Color.Gray, thickness = 1.dp, startIndent = 16.dp)
            Text("Sales and Deals", modifier)
            Divider(Modifier, Color.Gray, thickness = 1.dp, startIndent = 16.dp)
            Text("Action logs", modifier)
        }
    }
}