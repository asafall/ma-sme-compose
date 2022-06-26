package az.asaf.ma_sme_compose.data.repository

import az.asaf.ma_sme_compose.data.dto.CumulativeAccountDto

class CumulativeAccountsRepo {

    fun getCumulativeAccounts() = listOf(
        cumulativeAccount1,
        cumulativeAccount2,
        cumulativeAccount3
    )

    /**  FAKE DATA -> HARD CODING  */

    private val cumulativeAccount1 = CumulativeAccountDto(
        balance = 74383.0,
        todayIncome = 935.0,
        todayOutcome = 157.2,
        currencyCode = "AZN"
    )

    private val cumulativeAccount2 = CumulativeAccountDto(
        balance = 4714.1,
        todayIncome = 199.6,
        todayOutcome = 43.0,
        currencyCode = "USD"
    )

    private val cumulativeAccount3 = CumulativeAccountDto(
        balance = 379554.8,
        todayIncome = 76002.0,
        todayOutcome = 986.1,
        currencyCode = "RUB"
    )
}

