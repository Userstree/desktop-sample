import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import home.Update

@Composable
fun HomeScreen(

) {
    val scrollState = rememberScrollState()

    Column(
        modifier = Modifier.wrapContentHeight().fillMaxWidth().verticalScroll(scrollState)
    ) {
        Text(modifier = Modifier.fillMaxWidth().padding(16.dp), text = "Zapis-Demo")
        Row(modifier = Modifier.fillMaxWidth()) {
            Column(modifier = Modifier.weight(1f)) {
                ReservationDetailsComponent()
                SubscriptionDetailsComponent()
                FirmInformationDetailsComponent()
                MyCompaniesDetailsComponent()
            }
            Column(modifier = Modifier.weight(1f)) {
                NotesComponent()
                WebsiteUpdatesComponent()
            }
        }
        Footer()
    }
}

@Composable
fun HomeScreenCardComponent(
    title: String,
    subtitle: String,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier.height(96.dp).padding(4.dp).background(Color.White, RoundedCornerShape(4.dp)).padding(4.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        Text(title)
        Text(subtitle)
    }
}


@Composable
fun ReservationDetailsComponent() {
    Column(Modifier.fillMaxWidth().padding(16.dp).background(gray, RoundedCornerShape(4.dp))) {
        Text("Reservations", modifier = Modifier.padding(16.dp))
        val modifier = Modifier.weight(1f)
        Row(Modifier.padding(8.dp)) {
            HomeScreenCardComponent("1", "For the next 30 days", modifier)
            HomeScreenCardComponent("1", "Online reservation awaiting", modifier)
            HomeScreenCardComponent("0", "Feedbacks in the last 7 days", modifier)
        }
    }
}


@Composable
fun SubscriptionDetailsComponent() {
    Column(Modifier.fillMaxWidth().padding(16.dp).background(gray, RoundedCornerShape(4.dp))) {
        Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
            Text("Subscription", modifier = Modifier.padding(16.dp))
            TextButton(onClick = {}, modifier = Modifier.padding(8.dp)) {
                Text("Renew")
            }
        }
        val modifier = Modifier.weight(1f)
        Row(Modifier.padding(8.dp)) {
            HomeScreenCardComponent("01.09.2030", "Active until", modifier)
            HomeScreenCardComponent("0", "Sms left", modifier)
            HomeScreenCardComponent("1 336 ₸", "Debt for Sms", modifier)
        }
    }
}

@Composable
fun FirmInformationDetailsComponent() {
    Column(Modifier.fillMaxWidth().padding(16.dp).background(gray, RoundedCornerShape(4.dp))) {
        Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
            Text("Firm Information", modifier = Modifier.padding(16.dp))
            TextButton(onClick = {}, modifier = Modifier.padding(8.dp)) {
                Text("Edit")
            }
        }
        Row(Modifier.fillMaxWidth()) {
            Spacer(Modifier.height(8.dp))
            Box(Modifier.padding(horizontal = 16.dp, vertical = 8.dp).size(196.dp).background(Color.Gray))
            Column(Modifier.fillMaxWidth()) {
                Row(Modifier.padding(8.dp)) {
                    Text("Title", Modifier.weight(1f))
                    Column(Modifier.weight(2f)) {
                        Text("Zapis Demo")
                    }
                }
                Row(Modifier.padding(8.dp)) {
                    Text("Working hours", Modifier.weight(1f))
                    Column(Modifier.weight(2f)) {
                        Text("09:00 - 22:00")
                    }
                }
                Row(Modifier.padding(8.dp)) {
                    Text("Phone", Modifier.weight(1f))
                    Column(Modifier.weight(2f)) {
                        Text("+7 (707) 70-999-70")
                        Text("+7 (707) 40-999-40")
                        Text("+7 (707) 20-999-20")
                    }
                }
                Row(Modifier.padding(8.dp)) {
                    Text("Address", Modifier.weight(1f))
                    Column(Modifier.weight(2f)) {
                        Text("пр. Аль-Фараби 93")
                        Text("пр. Аль-Фараби 45")
                        Text("ул. Каирбекова 340")
                    }
                }
            }
        }
        Spacer(Modifier.height(8.dp))
    }
}

@Composable
fun RowScope.TableCell(
    text: String,
    weight: Float
) {
    Text(
        text = text,
        Modifier
            .border(1.dp, Color.Black)
            .weight(weight)
            .padding(8.dp)
    )
}

data class Company(
    val type: String,
    val title: String,
    val iin: String,
    val address: String,
) {
    companion object {
        fun getMyCompanies() = listOf(
            Company(type = "ИП", title = "Имидж-студия Хаджаевых", iin = "550922400111", address = "пр. Достык 109а"),
            Company(
                type = "ИП",
                title = "STUDIO MAVRINA",
                iin = "800721301431",
                address = "г.Алматы, 2 микрорайон, дом 35, офис (кв) 35\n"
            ),
        )
    }
}

@Composable
fun MyCompaniesDetailsComponent() {

    Column(Modifier.fillMaxWidth().padding(16.dp).background(gray, RoundedCornerShape(4.dp))) {
        Text("Your companies", modifier = Modifier.padding(16.dp))

        val column1Weight = 1.5f
        val column2Weight = 5f
        val column3Weight = 3f
        val column4Weight = 8f

        Row(Modifier.fillMaxWidth().padding(horizontal = 16.dp).background(Color.Gray)) {
            TableCell(text = "Type", weight = column1Weight)
            TableCell(text = "Title", weight = column2Weight)
            TableCell(text = "IIN", weight = column3Weight)
            TableCell(text = "Address", weight = column4Weight)
        }

        Company.getMyCompanies().forEach {
            Row(Modifier.fillMaxWidth().padding(horizontal = 16.dp)) {
                TableCell(text = it.type, weight = column1Weight)
                TableCell(text = it.title, weight = column2Weight)
                TableCell(text = it.iin, weight = column3Weight)
                TableCell(text = it.address, weight = column4Weight)
            }
        }
    }
}

data class Note(
    val title: String,
    val text: String,
    val time: String,
    val author: String,
) {
    companion object {
        fun getMyNotes() = listOf(
            Note(title = "Директору", text = "текст", time = "4 дня назад, 14:41", author = "Автор: Демо"),
            Note(title = "Админу", text = "текст", time = "4 дня назад, 14:40", author = "Автор: Демо"),
            Note(
                title = "Нерабочее время ",
                text = "Адель Иманкалиева 19:30-21:00 13 июля",
                time = "13 дней назад, 12:10",
                author = "Автор: Демо"
            ),
        )
    }
}


@Composable
fun NotesComponent() {
    Column(Modifier.fillMaxWidth().padding(16.dp).background(gray, RoundedCornerShape(4.dp))) {
        Text("Notes", modifier = Modifier.padding(16.dp))
        Note.getMyNotes().forEach {
            Row(Modifier.fillMaxWidth().padding(8.dp)) {
                Box(Modifier.height(80.dp).width(12.dp).background(Color.Red))
                Column {
                    Text(it.title)
                    Text(it.text)
                    Text(it.time)
                    Text(it.author)
                }
            }
        }
    }
}


@Composable
fun WebsiteUpdatesComponent() {
    Column(Modifier.fillMaxWidth().padding(16.dp).background(gray, RoundedCornerShape(4.dp))) {
        Text("Website Updates", modifier = Modifier.padding(16.dp))
        Update.getMyUpdates().forEach {
            Row(Modifier.fillMaxWidth().padding(horizontal = 16.dp, vertical = 8.dp)) {
                Column {
                    Text(it.version)
                    Text(it.description)
                    Text(it.date)
                }
            }
            Spacer(Modifier.height(12.dp))
        }
    }
}
