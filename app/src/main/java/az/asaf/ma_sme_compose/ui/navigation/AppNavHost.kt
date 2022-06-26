package az.asaf.ma_sme_compose.ui.navigation

import androidx.compose.material3.windowsizeclass.WindowSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import az.asaf.ma_sme_compose.ui.flow.tabs.accounts.navigation.setAccountsGraph
import az.asaf.ma_sme_compose.ui.flow.tabs.main.navigation.setMainGraph
import az.asaf.ma_sme_compose.ui.flow.tabs.main.scenes.transactions.navigation.AllTransactionsNav
import az.asaf.ma_sme_compose.ui.flow.tabs.main.scenes.transactions.navigation.setAllTransactionsGraph

@Composable
fun AppNavHost(
    modifier: Modifier = Modifier,
    windowSize: WindowSizeClass,
    navController: NavHostController,
    startDestination: String
) {
    NavHost(
        navController = navController,
        startDestination = startDestination,
        modifier = modifier,
        builder = {
            setMainGraph(
                windowSize = windowSize,
                navigateToAllTransactions = { navController.navigate(AllTransactionsNav.route) },
                nestedGraphs = {
                    setAllTransactionsGraph(windowSize)
                })
            setAccountsGraph(windowSize)
        })
}