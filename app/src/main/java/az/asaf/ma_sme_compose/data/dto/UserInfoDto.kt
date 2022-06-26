package az.asaf.ma_sme_compose.data.dto

data class UserInfoDto(
    val id: String,
    val firstName: String,
    val lastName: String,
    val userPhoto: String,
    val defaultSignMethod: SignMethod?,
    var customers: List<Customer>
) {

    fun getFullName() = "$firstName $lastName"

    enum class SignMethod { ASAN, OTP }

    data class Customer(
        val id: String,
        val name: String,
        val superUser: Boolean,
    )
}