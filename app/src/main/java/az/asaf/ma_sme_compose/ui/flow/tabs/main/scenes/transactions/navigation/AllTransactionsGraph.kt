package az.asaf.ma_sme_compose.ui.flow.tabs.main.scenes.transactions.navigation

import androidx.compose.material3.windowsizeclass.WindowSizeClass
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import az.asaf.ma_sme_compose.ui.flow.tabs.main.scenes.transactions.ui.AllTransactionsRoute


fun NavGraphBuilder.setAllTransactionsGraph(windowSize: WindowSizeClass) {
    composable(
        route = AllTransactionsNav.route,
        content = { AllTransactionsRoute(windowSize) }
    )
}