package profile

import core.BaseRepository
//import io.ktor.client.*
//import io.ktor.client.engine.cio.*
//import io.ktor.client.features.json.*
//import io.ktor.client.features.json.serializer.*
//import io.ktor.client.features.observer.*
//import io.ktor.client.request.*
//import io.ktor.client.statement.*
//import io.ktor.util.*


class ProfileRepository : BaseRepository() {

//    private val httpClient: HttpClient = HttpClient(CIO) {
//        install(ResponseObserver) {
//            onResponse { response ->
//                println("HTTP status: ${response.status.value}")
//            }
//        }
//        install(JsonFeature) {
//            serializer = KotlinxSerializer(kotlinx.serialization.json.Json {
//                prettyPrint = true
//                isLenient = true
//            })
//        }
//    }
//
//    suspend fun getProfileScreenData() = getResponse<ProfileScreenData> { getProfile() }
//
//    @OptIn(InternalAPI::class)
//    suspend fun getProfile(): HttpResponse =
//        httpClient.get("https://zs.khangroup.kz/rest/clients-app/v1/my/profiles") {
//            headers {
//                append("api_key", "8e56a169-e1d6-48e6-b29d-27f60b701a54")
//                append("referrer", "android")
//                append("city_id", "1")
//                append("android_app_version", "250")
//                append("api_version", "13")
//                append(
//                    "device_token",
//                    "fwIS1vtfSI-d7bprnudCLr:APA91bHBly77FXUDaJwM9q8fnxPNcQ-lXnd8WZG-6BJliVmEadPiMIIr0rmA9nXrqkNzV8ghFRJjExy8tS2tTDoyyXl1dX3NWoix7ugU5HVL_eoENtBdGgG829quUi8zuwps8E78ubDa"
//                )
//                append("user_id", "193914")
//                append(
//                    "access_token",
//                    "eyJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJ6YXBpc0t6In0.6iKprFCkbJ_6NPXpHUfpy0Wh_jAsam9vOKhPSrb-x0Y"
//                )
//            }
//        }

}