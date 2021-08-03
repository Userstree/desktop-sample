package common

data class Envelope<T> constructor(
    val message: String?,
    val data: T?
)