package az.asaf.ma_sme_compose.data.dto

data class CumulativeAccountDto(
    val balance: Double,
    val todayIncome: Double,
    val todayOutcome: Double,
    val currencyCode: String
)

