package az.asaf.ma_sme_compose.data.repository

import az.asaf.ma_sme_compose.data.dto.UserInfoDto
import kotlin.random.Random

class UserInfoRepo {

    fun getUserInfo() = userInfo

    /**  FAKE DATA -> HARD CODING  */

    private val customers = List(30) {
        UserInfoDto.Customer(
            id = it.toString(),
            name = "Any MMC",
            superUser = it == 1,
        )
    }

    private val userInfo = UserInfoDto(
        id = "1",
        firstName = "Asaf",
        lastName = "Allahverdiyev",
        userPhoto = "https://www.gravatar.com/avatar/205e460b479e2e5b48aec07710c08d50",
        defaultSignMethod = UserInfoDto.SignMethod.OTP,
        customers = customers
    )
}