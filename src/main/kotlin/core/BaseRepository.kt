package core

import common.Envelope
import common.ResponseState.NetworkResponse

abstract class BaseRepository {

//    suspend fun <T> getResponse(call: suspend () -> HttpResponse): NetworkResponse<Envelope<T>> {
//        return try {
//            val response = call()
//            when (val code = response.status.value) {
//                in 200..299 -> {
//                    val data = response.receive<Envelope<T>>()
//                    if (data.data != null) {
//                        NetworkResponse.Success(data)
//                    } else {
//                        NetworkResponse.Error.UnknownError("body is null")
//                    }
//                }
//                in 400..499 -> {
//                    if (code == 401) {
////                        sharedPreferencesManager.logout()
//                        NetworkResponse.Error.UnauthenticatedError()
//                    } else {
//                        val data = response.receive<Envelope<T>>()
//                        NetworkResponse.Error.UnknownError(
//                            data.message
//                        )
//                    }
//                }
//                in 500..599 -> NetworkResponse.Error.ServerError()
//                else -> NetworkResponse.Error.UnknownError()
//            }
//        } catch (e: Exception) {
//            NetworkResponse.Error.UnknownError(e.message)
//        }
//    }
}