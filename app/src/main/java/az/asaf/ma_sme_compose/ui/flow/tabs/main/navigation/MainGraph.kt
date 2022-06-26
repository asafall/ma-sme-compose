package az.asaf.ma_sme_compose.ui.flow.tabs.main.navigation

import androidx.compose.material3.windowsizeclass.WindowSizeClass
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import az.asaf.ma_sme_compose.ui.flow.tabs.main.MainRoute

fun NavGraphBuilder.setMainGraph(
    windowSize: WindowSizeClass,
    navigateToAllTransactions: () -> Unit,
    nestedGraphs: () -> Unit
) {
    navigation(
        route = MainNav.route,
        startDestination = MainNav.destination,
        builder = {
            composable(
                route = MainNav.destination,
                content = {
                    MainRoute(windowSize, navigateToAllTransactions)
                }
            )
            nestedGraphs()
        }
    )
}