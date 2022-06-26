package az.asaf.ma_sme_compose.ui.navigation

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import az.asaf.ma_sme_compose.R
import az.asaf.ma_sme_compose.ui.flow.tabs.accounts.navigation.AccountsNav
import az.asaf.ma_sme_compose.ui.flow.tabs.main.navigation.MainNav

class TopLevelNavigation(private val navController: NavHostController) {

    fun navigateTo(destination: TopLevelDestination) {
        navController.navigate(destination.route) {
            // Pop up to the start destination of the graph to
            // avoid building up a large stack of destinations
            // on the back stack as users select items
            popUpTo(navController.graph.findStartDestination().id) {
                saveState = true
            }
            // Avoid multiple copies of the same destination when
            // re selecting the same item
            launchSingleTop = true
            // Restore state when re selecting a previously selected item
            restoreState = true
        }
    }
}

data class TopLevelDestination(
    val route: String,
    @DrawableRes val selectedIconId: Int,
    @DrawableRes val unselectedIconId: Int,
    @StringRes val iconTextId: Int
)

interface NavigationDestination {
    val route: String
    val destination: String
}

val TOP_LEVEL_DESTINATIONS = listOf(
    TopLevelDestination(
        route = MainNav.route,
        selectedIconId = R.drawable.img_tab_main_selected,
        unselectedIconId = R.drawable.ic_tab_main_unselected,
        iconTextId = R.string.tab_main
    ),
    TopLevelDestination(
        route = AccountsNav.route,
        selectedIconId = R.drawable.img_tab_account_selected,
        unselectedIconId = R.drawable.ic_tab_account_unselected,
        iconTextId = R.string.tab_accounts
    )
)