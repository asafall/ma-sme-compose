package az.asaf.ma_sme_compose.ui.utils.extensions.ui

import android.content.Context
import android.widget.Toast
import az.asaf.ma_sme_compose.ui.utils.extensions.kotlin.toSafeString

fun showToast(
    context: Context,
    text: Any?,
    length: Int = Toast.LENGTH_SHORT
) {
    Toast.makeText(context, text.toSafeString(), length).show()
}