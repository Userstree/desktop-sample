package profile

//import kotlinx.serialization.Serializable
//
//@Serializable
data class User(
    val id: Int,
    val phoneNumber: String,
    val name: String,
    val surname: String,
    val email: String,
    val status: String,
    val gender: String,
    val birthday: String,
    val isCardBound: Boolean,
    val avatarUrl: String,
)