package az.asaf.ma_sme_compose.ui.flow.tabs.main.ui

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Icon
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import androidx.lifecycle.viewmodel.compose.viewModel
import az.asaf.ma_sme_compose.R
import az.asaf.ma_sme_compose.data.dto.TransactionDto
import az.asaf.ma_sme_compose.ui.common.LazyListBlock
import az.asaf.ma_sme_compose.ui.flow.tabs.main.MainViewModel

@Preview
@Composable
private fun PreviewLastTransactions() {
    LastTransactionsBlock(viewModel = viewModel())
}

@Composable
fun LastTransactionsBlock(
    modifier: Modifier = Modifier,
    viewModel: MainViewModel
) {
    LazyListBlock(
        blockTitle = stringResource(R.string.last_transactions),
        hasButton = true,
        modifier = modifier,
        items = {
            LastTransactionsLazyColumn(transactions = viewModel.transactions)
        }
    )
}

@Composable
private fun LastTransactionsLazyColumn(
    modifier: Modifier = Modifier,
    transactions: List<TransactionDto>
) {
    LazyColumn(
        contentPadding = PaddingValues(vertical = 8.dp, horizontal = 16.dp),
        verticalArrangement = Arrangement.spacedBy(4.dp),
        modifier = modifier.verticalScroll(rememberScrollState())
    ) {
        items(transactions.size) { index ->
            val item = transactions[index]
            LastTransactionsItem(
                customerName = item.customerName,
                description = item.description,
                amount = item.amount
            )
        }
    }
}

@Composable
fun LastTransactionsItem(
    modifier: Modifier = Modifier,
    customerName: String,
    description: String,
    amount: TransactionDto.Amount
) {
    Surface(
        shape = CircleShape.copy(all = CornerSize(12.dp)),
        modifier = modifier
            .fillMaxWidth()
            .padding(start = 16.dp, end = 16.dp, bottom = 4.dp)
    ) {
        ConstraintLayout {
            val (iconType, txtCustomerName, txtDesc, txtAmount) = createRefs()
            Icon(
                painter = painterResource(R.drawable.ic_green_circular_earth),
                contentDescription = "earth_icon",
                modifier = Modifier
                    .size(40.dp)
                    .constrainAs(iconType) {
                        top.linkTo(parent.top, margin = 16.dp)
                        start.linkTo(parent.start, margin = 16.dp)
                    }
            )
            Text(
                text = customerName,
                fontSize = 17.sp,
                letterSpacing = (-0.41).sp,
                color = colorResource(R.color.text_transaction_item_customer_name),
                modifier = Modifier.constrainAs(txtCustomerName) {
                    top.linkTo(parent.top, margin = 16.dp)
                    start.linkTo(iconType.end, margin = 12.dp)
                    end.linkTo(txtAmount.start, margin = 16.dp)
                    width = Dimension.fillToConstraints
                }
            )
            Text(
                text = description,
                fontSize = 12.sp,
                color = colorResource(R.color.text_transaction_item_description),
                modifier = Modifier.constrainAs(txtDesc) {
                    top.linkTo(txtCustomerName.bottom, margin = 2.dp)
                    bottom.linkTo(parent.bottom, margin = 16.dp)
                    start.linkTo(txtCustomerName.start)
                    end.linkTo(txtCustomerName.end)
                    width = Dimension.fillToConstraints
                }
            )
            Text(
                text = "${amount.value} ${amount.currencyCode}",
                fontSize = 15.sp,
                color = colorResource(R.color.text_transaction_item_amount),
                modifier = Modifier.constrainAs(txtAmount) {
                    top.linkTo(parent.top, margin = 18.dp)
                    end.linkTo(parent.end, margin = 16.dp)
                }
            )
        }
    }
}