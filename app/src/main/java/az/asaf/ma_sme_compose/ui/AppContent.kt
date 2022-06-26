package az.asaf.ma_sme_compose.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.windowsizeclass.WindowSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import az.asaf.ma_sme_compose.R
import az.asaf.ma_sme_compose.ui.flow.tabs.main.navigation.MainNav
import az.asaf.ma_sme_compose.ui.navigation.AppNavHost
import az.asaf.ma_sme_compose.ui.navigation.TOP_LEVEL_DESTINATIONS
import az.asaf.ma_sme_compose.ui.navigation.TopLevelDestination
import az.asaf.ma_sme_compose.ui.navigation.TopLevelNavigation
import com.google.accompanist.pager.ExperimentalPagerApi

@ExperimentalPagerApi
@Composable
fun MainApp(windowSize: WindowSizeClass) {
    val navController = rememberNavController()
    val topLevelDestination = remember {
        TopLevelNavigation(navController)
    }
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination

    Scaffold(
        bottomBar = {
            AppNavigationBar(
                currentDestination = currentDestination,
                onNavigateToTopLevelDestination = topLevelDestination::navigateTo
            )
        },
        content = {
            AppNavHost(
                windowSize = windowSize,
                navController = navController,
                startDestination = MainNav.route,
                modifier = Modifier.padding(bottom = 76.dp)
            )
        })
}


@Composable
fun AppNavigationBar(
    modifier: Modifier = Modifier,
    currentDestination: NavDestination?,
    onNavigateToTopLevelDestination: (TopLevelDestination) -> Unit
) {
    NavigationBar(
        containerColor = colorResource(R.color.app_bottom_navigation),
        modifier = modifier
            .height(76.dp)
            .fillMaxWidth()
    ) {
        TOP_LEVEL_DESTINATIONS.forEach{ destination ->
            val selected =
                currentDestination?.hierarchy?.any { it.route == destination.route } == true

            NavigationBarItem(
                selected = selected,
                onClick = { onNavigateToTopLevelDestination(destination) },
                label = {
                    Text(
                        text = stringResource(id = destination.iconTextId),
                        fontSize = 10.sp,
                        fontWeight = FontWeight.Medium,
                        color = colorResource(id = R.color.text_bottom_nav)
                    )
                },
                icon = {
                    Icon(
                        if (selected) painterResource(destination.selectedIconId)
                        else painterResource(id = destination.unselectedIconId),
                        contentDescription = null,
                        modifier = Modifier.size(20.dp)
                    )
                })
        }
    }
}