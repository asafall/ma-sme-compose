package az.asaf.ma_sme_compose.ui.flow.enums

import androidx.annotation.DrawableRes
import az.asaf.ma_sme_compose.R

enum class PaymentType {
    AZN_PAYMENT, // DOMESTIC
    INTERNAL_PAYMENT,
    OWN_ACCOUNTS_PAYMENT,
    FX_PAYMENT, // FOREIGN EXCHANGE
    INTERNATIONAL_PAYMENT,
    TAX_PAYMENT, // TAX & BUDGET
    GPP_PAYMENT, // GOVERNMENT
    IPS_PAYMENT,
    SALARY;

    enum class Create {
        AZN_PAYMENT,
        INTERNAL_PAYMENT,
        OWN_ACCOUNTS_PAYMENT,
        TAX_PAYMENT
    }


    companion object {
        fun mobileBasedTypes(): List<PaymentType> {
            return listOf(
                AZN_PAYMENT,
                INTERNAL_PAYMENT,
                OWN_ACCOUNTS_PAYMENT,
                TAX_PAYMENT
            )
        }
    }

    fun toLowercaseType(): String {
        return when (this) {
            AZN_PAYMENT -> "payment-azn"
            INTERNAL_PAYMENT -> "payment-internal"
            OWN_ACCOUNTS_PAYMENT -> "payment-own"
            FX_PAYMENT -> "payment-fx"
            INTERNATIONAL_PAYMENT -> "payment-international"
            TAX_PAYMENT -> "payment-tax"
            GPP_PAYMENT -> "payment-gpp"
            SALARY -> "payment-salary"
            IPS_PAYMENT -> "payment-ips"
        }
    }

    @DrawableRes
    fun getDrawableRes(): Int {
        return when (this) {
            AZN_PAYMENT -> R.drawable.ic_green_circular_earth
            INTERNAL_PAYMENT -> R.drawable.ic_green_circular_earth
            OWN_ACCOUNTS_PAYMENT -> R.drawable.ic_green_circular_earth
            FX_PAYMENT -> R.drawable.ic_green_circular_earth
            INTERNATIONAL_PAYMENT -> R.drawable.ic_green_circular_earth
            TAX_PAYMENT -> R.drawable.ic_green_circular_earth
            GPP_PAYMENT -> R.drawable.ic_green_circular_earth
            SALARY -> R.drawable.ic_green_circular_earth
            IPS_PAYMENT -> R.drawable.ic_green_circular_earth
        }
    }

    @DrawableRes
    fun getDrawableResGrey(): Int {
        return when (this) {
            AZN_PAYMENT -> R.drawable.ic_green_circular_earth
            INTERNAL_PAYMENT -> R.drawable.ic_green_circular_earth
            OWN_ACCOUNTS_PAYMENT -> R.drawable.ic_green_circular_earth
            FX_PAYMENT -> R.drawable.ic_green_circular_earth
            INTERNATIONAL_PAYMENT -> R.drawable.ic_green_circular_earth
            TAX_PAYMENT -> R.drawable.ic_green_circular_earth
            GPP_PAYMENT -> R.drawable.ic_green_circular_earth
            SALARY -> R.drawable.ic_green_circular_earth
            IPS_PAYMENT -> R.drawable.ic_green_circular_earth
        }
    }
}