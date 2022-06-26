package az.asaf.ma_sme_compose.data.dto

import az.asaf.ma_sme_compose.ui.flow.enums.PaymentType

data class TemplateDto(
    val id: Int,
    val type: PaymentType,
    val customerName: String,
    val accountName: String
)