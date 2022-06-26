package az.asaf.ma_sme_compose.ui.flow.tabs.main

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.windowsizeclass.WindowSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintSet
import androidx.constraintlayout.compose.Dimension
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.rememberNavController
import az.asaf.ma_sme_compose.R
import az.asaf.ma_sme_compose.ui.common.LazyListBlock
import az.asaf.ma_sme_compose.ui.flow.tabs.main.ui.*
import com.google.accompanist.pager.ExperimentalPagerApi

/** https://www.flickr.com/photos/195805982@N02/shares/046KHy */

@Composable
fun MainRoute(
    windowSize: WindowSizeClass,
    navigateToAllTransactions: () -> Unit
) {
    val navController = rememberNavController()
    MainScreen(windowSize, viewModel(), navigateToAllTransactions)
}

@OptIn(ExperimentalPagerApi::class)
@Composable
private fun MainScreen(
    windowSize: WindowSizeClass,
    viewModel: MainViewModel,
    navigateToAllTransactions: () -> Unit
) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(R.color.home_fragment_background))
    ) {
        item {
            MainToolbarSection(viewModel = viewModel)
        }
        item {
            CumulativeAccountsSection(viewModel = viewModel)
        }
        item {
            UnsignedPaymentsCountSection(
                viewModel = viewModel,
                modifier = Modifier.padding(all = 16.dp)
            )
        }
        item {
            TemplatesBlock(
                viewModel = viewModel,
                modifier = Modifier.padding(top = 2.dp)
            )
        }
        item {
            LazyListBlock(
                blockTitle = stringResource(R.string.last_transactions),
                hasButton = true,
                modifier = Modifier.padding(top = 18.dp),
                onClickAllButton = { navigateToAllTransactions.invoke() }
            )
        }
        items(viewModel.transactions.size) { index ->
            val item = viewModel.transactions[index]
            LastTransactionsItem(
                customerName = item.customerName,
                description = item.description,
                amount = item.amount
            )
        }
    }
}