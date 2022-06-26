package az.asaf.ma_sme_compose.data.dto

import az.asaf.ma_sme_compose.ui.flow.enums.PaymentType


data class TransactionDto(
    val id: Int,
    val paymentType: PaymentType,
    val customerName: String,
    val description: String,
    var date: String?,
    val amount: Amount,
) {
    data class Amount(
        var currencyCode: String?,
        var value: String?
    )
}