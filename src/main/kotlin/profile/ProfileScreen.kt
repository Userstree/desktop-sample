package profile

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import common.Envelope
import common.ResponseState

@Composable
fun ProfileScreen() {

//    var state: ResponseState<Envelope<ProfileScreenData>> by remember { mutableStateOf(ResponseState.Loading.Initial()) }
//
//    LaunchedEffect(true) {
//        state = ProfileRepository().getProfileScreenData()
//    }
//
//    Box(Modifier.fillMaxSize(), Alignment.Center) {
//        when (state) {
//            is ResponseState.NetworkResponse.Success -> {
//                Text((state as ResponseState.NetworkResponse.Success).data.data!!.user.name)
//            }
//            is ResponseState.Loading -> {
//                Text("Loading")
//            }
//            is ResponseState.NetworkResponse.Error -> {
//                Text((state as ResponseState.NetworkResponse.Error).message ?: "error")
//            }
//        }
//
//    }
}