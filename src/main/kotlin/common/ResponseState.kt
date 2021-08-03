package common

sealed class ResponseState<T> {

    sealed class Loading<T> : ResponseState<T>() {
        class Initial<T> : Loading<T>()
        class Refreshing<T> : Loading<T>()

        override fun <R> copy(convert: (T) -> R): Loading<R> {
            return when (this) {
                is Initial -> Initial()
                is Refreshing -> Refreshing()
            }
        }

    }

    sealed class NetworkResponse<T> : ResponseState<T>() {

        // this variable keeps track of whether the result has been handled or not.
        // it is needed to avoid showing the same error/success message multiple times.
        private var new = true

        fun isNew(): Boolean {
            return if (new) {
                new = false
                true
            } else false
        }

        // Total success: the data is fresh from the server.
        class Success<T>(var data: T) : NetworkResponse<T>() {
            override fun <R> copy(convert: (T) -> R): Success<R> {
                return Success(convert(data))
            }
        }

        sealed class Error<T>(val message: String?) : NetworkResponse<T>() {
            class UnknownError<T>(message: String? = null) : Error<T>(message)

            class UnauthenticatedError<T> : Error<T>(null)

            class NetworkError<T> : Error<T>(null)

            class ServerError<T> : Error<T>(null)

            override fun <R> copy(convert: (T) -> R): Error<R> {
                return when (this) {
                    is UnknownError -> UnknownError(message)
                    is UnauthenticatedError -> UnauthenticatedError()
                    is NetworkError -> NetworkError()
                    is ServerError -> ServerError()
                }
            }

        }

        override fun <R> copy(convert: (T) -> R): NetworkResponse<R> {
            return when (this) {
                is Success -> this.copy(convert)
                is Error -> this.copy(convert)
            }
        }

    }

    abstract fun <R> copy(convert: (T) -> R): ResponseState<R>

}