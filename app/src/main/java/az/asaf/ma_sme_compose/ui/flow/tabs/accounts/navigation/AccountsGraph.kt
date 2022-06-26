package az.asaf.ma_sme_compose.ui.flow.tabs.accounts.navigation

import androidx.compose.material3.windowsizeclass.WindowSizeClass
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import az.asaf.ma_sme_compose.ui.flow.tabs.accounts.ui.AccountsRoute
import az.asaf.ma_sme_compose.ui.flow.tabs.main.scenes.transactions.navigation.AllTransactionsNav
import az.asaf.ma_sme_compose.ui.flow.tabs.main.scenes.transactions.ui.AllTransactionsRoute

fun NavGraphBuilder.setAccountsGraph(windowSize: WindowSizeClass) {
    composable(
        route = AccountsNav.route,
        content = { AccountsRoute(windowSize) }
    )
}