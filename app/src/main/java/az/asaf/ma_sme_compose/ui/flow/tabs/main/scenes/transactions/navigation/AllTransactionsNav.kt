package az.asaf.ma_sme_compose.ui.flow.tabs.main.scenes.transactions.navigation

import az.asaf.ma_sme_compose.ui.navigation.NavigationDestination

object AllTransactionsNav: NavigationDestination {
    override val route: String
        get() = "all-transactions-route"
    override val destination: String
        get() = "all-transaction-destination"
}