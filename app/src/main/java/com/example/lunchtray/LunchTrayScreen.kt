package com.example.lunchtray

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.lunchtray.ui.OrderViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LunchTrayScreen(
    orderViewModel: OrderViewModel = viewModel()
) {
    val navController = rememberNavController()

    val backStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = backStackEntry?.destination?.route
    val currentScreen = Routes.entries.firstOrNull { it.route == currentRoute }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(text = stringResource(currentScreen?.titleRes ?: R.string.app_name))
                },
                navigationIcon = {
                    if (currentRoute != null && currentRoute != Routes.START.route) {
                        IconButton(onClick = { navController.navigateUp() }) {
                            Icon(
                                imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                                contentDescription = stringResource(R.string.back_button)
                            )
                        }
                    }
                }
            )
        }
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = Routes.START.route,
            modifier = Modifier.padding(innerPadding)
        ) {
            composable(Routes.START.route) {
                StartOrderScreen(
                    onStartOrder = { navController.navigate(Routes.ENTREE.route) }
                )
            }
            composable(Routes.ENTREE.route) {
                EntreeMenuScreen(
                    orderViewModel = orderViewModel,
                    onNext = { navController.navigate(Routes.SIDE_DISH.route) },
                    onCancel = {
                        orderViewModel.resetOrder()
                        navController.navigateToStart()
                    }
                )
            }
            composable(Routes.SIDE_DISH.route) {
                SideDishMenuScreen(
                    orderViewModel = orderViewModel,
                    onNext = { navController.navigate(Routes.ACCOMPANIMENT.route) },
                    onCancel = {
                        orderViewModel.resetOrder()
                        navController.navigateToStart()
                    }
                )
            }
            composable(Routes.ACCOMPANIMENT.route) {
                AccompanimentMenuScreen(
                    orderViewModel = orderViewModel,
                    onNext = { navController.navigate(Routes.CHECKOUT.route) },
                    onCancel = {
                        orderViewModel.resetOrder()
                        navController.navigateToStart()
                    }
                )
            }
            composable(Routes.CHECKOUT.route) {
                CheckoutScreen(
                    orderViewModel = orderViewModel,
                    onSend = {
                        orderViewModel.resetOrder()
                        navController.navigateToStart()
                    },
                    onCancel = {
                        orderViewModel.resetOrder()
                        navController.navigateToStart()
                    }
                )
            }
        }
    }
}

fun NavController.navigateToStart() {
    navigate(Routes.START.route) {
        popUpTo(graph.findStartDestination().id) {
            inclusive = false
        }
        launchSingleTop = true
    }
}