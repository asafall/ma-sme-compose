package az.asaf.ma_sme_compose.ui.flow.tabs.accounts.navigation

import az.asaf.ma_sme_compose.ui.navigation.NavigationDestination

object AccountsNav: NavigationDestination {
    override val route: String
        get() = "accounts-route"
    override val destination: String
        get() = "accounts-destination"
}