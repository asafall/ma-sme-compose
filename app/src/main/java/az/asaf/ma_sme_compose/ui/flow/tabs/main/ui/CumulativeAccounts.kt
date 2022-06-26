package az.asaf.ma_sme_compose.ui.flow.tabs.main.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import az.asaf.ma_sme_compose.data.dto.CumulativeAccountDto
import az.asaf.ma_sme_compose.ui.flow.tabs.main.MainViewModel
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState

@OptIn(ExperimentalPagerApi::class)
@Preview
@Composable
private fun PreviewCumulativeAccounts() {
    CumulativeAccountsSection(viewModel = viewModel())
}

@ExperimentalPagerApi
@Composable
fun CumulativeAccountsSection(
    modifier: Modifier = Modifier,
    viewModel: MainViewModel
) {
    val pagerState = rememberPagerState()
    HorizontalPager(
        count = viewModel.cumulativeAccounts.size,
        state = pagerState,
        contentPadding = PaddingValues(end = 32.dp),
        modifier = modifier
            .background(colorResource(az.asaf.ma_sme_compose.R.color.cumulative_accounts_background))
    ) { page ->
        val account = viewModel.cumulativeAccounts[page]
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 24.dp, start = 16.dp)
        ) {
            Text(
                fontSize = 17.sp,
                fontFamily = FontFamily.SansSerif,
                fontWeight = FontWeight.Normal,
                color = colorResource(az.asaf.ma_sme_compose.R.color.text_balance_currency_code),
                letterSpacing = (-0.41).sp,
                text = stringResource(
                    az.asaf.ma_sme_compose.R.string.common_balance_with_currency,
                    account.currencyCode
                )
            )
            Text(
                text = "${account.balance} ${account.currencyCode}",
                fontSize = 34.sp,
                fontFamily = FontFamily.SansSerif,
                fontWeight = FontWeight.Normal,
                color = colorResource(az.asaf.ma_sme_compose.R.color.text_account_balance),
                letterSpacing = (0.37).sp,
                modifier = Modifier.padding(top = 8.dp, bottom = 8.dp)
            )
            ActionsOfToday(
                account = account,
                modifier = Modifier.padding(bottom = 10.dp)
            )
        }
    }
}

@Composable
private fun ActionsOfToday(
    modifier: Modifier = Modifier,
    account: CumulativeAccountDto
) {
    Row(modifier = modifier) {
        TodayOutcomeOrIncomeSection(
            isIncome = true,
            value = account.todayIncome.toString(),
            currencyCode = account.currencyCode
        )
        Spacer(modifier = Modifier.width(13.dp))
        TodayOutcomeOrIncomeSection(
            isIncome = false,
            value = account.todayOutcome.toString(),
            currencyCode = account.currencyCode
        )
    }
}

@Composable
private fun TodayOutcomeOrIncomeSection(
    modifier: Modifier = Modifier,
    isIncome: Boolean,
    value: String,
    currencyCode: String
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
    ) {
        Text(
            text = if (isIncome)
                stringResource(az.asaf.ma_sme_compose.R.string.today_income) + ":"
            else stringResource(az.asaf.ma_sme_compose.R.string.today_outcome) + ":",
            fontSize = 12.sp,
            fontWeight = FontWeight.Medium,
            fontFamily = FontFamily.SansSerif,
            color = colorResource(az.asaf.ma_sme_compose.R.color.text_today_outcome_income)
        )
        Spacer(modifier = Modifier.width(7.dp))
        Text(
            text = if (isIncome) "+$value $currencyCode"
            else "-$value $currencyCode",
            fontSize = 12.sp,
            fontWeight = FontWeight.Medium,
            fontFamily = FontFamily.SansSerif,
            color = colorResource(az.asaf.ma_sme_compose.R.color.text_outcome_income_value)
        )
    }
}