package az.asaf.ma_sme_compose.ui.flow.tabs.main.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.intl.Locale
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import az.asaf.ma_sme_compose.R
import az.asaf.ma_sme_compose.data.dto.TemplateDto
import az.asaf.ma_sme_compose.ui.common.LazyListBlock
import az.asaf.ma_sme_compose.ui.flow.tabs.main.MainViewModel
import az.asaf.ma_sme_compose.ui.utils.extensions.ui.showToast

@Preview
@Composable
private fun PreviewTemplatesBlock() {
    TemplatesBlock(viewModel = viewModel())
}

@Composable
fun TemplatesBlock(
    modifier: Modifier = Modifier,
    viewModel: MainViewModel
) {
    val context = LocalContext.current
    LazyListBlock(
        blockTitle = stringResource(R.string.templates),
        hasButton = true,
        modifier = modifier,
        items = { TemplatesLazyRow(viewModel.templates) },
        onClickAllButton = {
            showToast(context, "test")
        })
}

@Composable
private fun TemplatesLazyRow(
    items: List<TemplateDto>,
    modifier: Modifier = Modifier
) {
    LazyRow(
        contentPadding = PaddingValues(horizontal = 16.dp),
        horizontalArrangement = Arrangement.spacedBy(9.dp),
        modifier = modifier
    ) {
        items(items.size) { index ->
            val item = items[index]
            TemplatesItem(
                customerName = item.customerName,
                accountName = item.accountName
            )
        }
    }
}

@Composable
private fun TemplatesItem(
    modifier: Modifier = Modifier,
    customerName: String,
    accountName: String
) {
    Surface(
        shape = CircleShape.copy(all = CornerSize(12.dp)),
        modifier = modifier.width(167.dp)
    ) {
        Column {
            Image(
                painter = painterResource(id = R.drawable.ic_green_circular_earth),
                contentDescription = "green_earth",
                modifier = Modifier
                    .size(40.dp)
                    .padding(top = 16.dp, start = 16.dp)
            )
            Text(
                text = customerName,
                fontSize = 17.sp,
                color = colorResource(R.color.text_template_item_customer_name),
                letterSpacing = (-0.41).sp,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                modifier = Modifier.padding(top = 24.dp, start = 16.dp, end = 16.dp)
            )
            Text(
                text = accountName,
                fontSize = 12.sp,
                color = colorResource(R.color.text_template_item_account_name),
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                modifier = Modifier
                    .padding(top = 2.dp, bottom = 16.dp, start = 16.dp, end = 16.dp)
            )
        }
    }
}