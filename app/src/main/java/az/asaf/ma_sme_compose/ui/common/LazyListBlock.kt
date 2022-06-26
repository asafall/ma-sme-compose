package az.asaf.ma_sme_compose.ui.common

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.ParagraphStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import az.asaf.ma_sme_compose.R

@Composable
fun LazyListBlock(
    modifier: Modifier = Modifier,
    blockTitle: String,
    hasButton: Boolean,
    buttonTitle: String = stringResource(R.string.show_everything),
    items: @Composable () -> Unit = {},
    onClickAllButton: () -> Unit = {}
) {
    Column(modifier = modifier) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = blockTitle,
                fontSize = 17.sp,
                color = colorResource(R.color.text_lazy_row_block_title),
                letterSpacing = (-0.41).sp,
                modifier = Modifier.padding(start = 16.dp)
            )
            if (hasButton) {
                ClickableText(
                    text = AnnotatedString(buttonTitle, ParagraphStyle()),
                    onClick = { onClickAllButton.invoke() },
                    modifier = Modifier.padding(end = 16.dp),
                    style = TextStyle(
                        fontSize = 15.sp,
                        color = colorResource(R.color.text_lazy_row_block_button),
                        letterSpacing = (-0.24).sp
                    )
                )
            }
        }
        Spacer(modifier = Modifier.height(8.dp))
        items()
    }
}