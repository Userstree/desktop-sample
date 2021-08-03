import androidx.compose.foundation.layout.*
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun Footer(modifier: Modifier = Modifier) {
    Column(modifier.fillMaxWidth()) {
        Divider(Modifier.fillMaxWidth(), Color.Gray)
        Spacer(Modifier.height(12.dp))
        Row(Modifier.fillMaxWidth(), Arrangement.SpaceBetween) {
            Text("Go Home", Modifier.padding(horizontal = 12.dp))
            Text("Support", Modifier.padding(horizontal = 12.dp))
        }
        Spacer(Modifier.height(12.dp))
        Row(Modifier.fillMaxWidth(), Arrangement.SpaceBetween) {
            Text("© ZAPIS KZ LLP 2017 - 2021", Modifier.padding(horizontal = 12.dp))
            Text("Cделано с  в Khan Group", Modifier.padding(horizontal = 12.dp))
        }
        Spacer(Modifier.height(128.dp))
    }
}