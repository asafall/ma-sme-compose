package az.asaf.ma_sme_compose.data.repository

import az.asaf.ma_sme_compose.data.dto.TemplateDto
import az.asaf.ma_sme_compose.ui.flow.enums.PaymentType

class TemplatesRepo {

    fun getTemplates() = listOf(
        template1,
        template2,
        template3,
        template4
    )

    /**  FAKE DATA -> HARD CODING  */

    private val template1 = TemplateDto(
        id = 1,
        type = PaymentType.AZN_PAYMENT,
        customerName = "Any MMC",
        accountName = "AZ07PAHA098471AZN1111"
    )

    private val template2 = TemplateDto(
        id = 2,
        type = PaymentType.INTERNAL_PAYMENT,
        customerName = "Random MMC",
        accountName = "AZ07PAHA34857AZN1111"
    )

    private val template3 = TemplateDto(
        id = 3,
        type = PaymentType.INTERNATIONAL_PAYMENT,
        customerName = "Next MMC",
        accountName = "AZ07PAHA089321AZN1111"
    )

    private val template4 = TemplateDto(
        id = 4,
        type = PaymentType.SALARY,
        customerName = "Nice MMC",
        accountName = "AZ07PAHA65902AZN1111"
    )
}