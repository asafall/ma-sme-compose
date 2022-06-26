package az.asaf.ma_sme_compose.ui.flow.tabs.main.scenes.transactions.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.material3.windowsizeclass.WindowSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@Composable
fun AllTransactionsRoute(windowSize: WindowSizeClass) {
    AllTransactionsScreen(windowSize)
}

@Composable
fun AllTransactionsScreen(windowSize: WindowSizeClass) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxSize()
    ){
        Text(text = "All Transactions Screen")
    }
}