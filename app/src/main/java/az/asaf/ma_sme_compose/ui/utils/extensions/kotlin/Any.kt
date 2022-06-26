package az.asaf.ma_sme_compose.ui.utils.extensions.kotlin

fun Any?.toSafeString(): String {
    this?.let {
        return it.toString()
    } ?: return ""
}