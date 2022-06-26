package az.asaf.ma_sme_compose.ui.flow.tabs.main.navigation

import az.asaf.ma_sme_compose.ui.navigation.NavigationDestination

object MainNav: NavigationDestination {
    override val route: String
        get() = "main-route"
    override val destination: String
        get() = "main-destination"
}