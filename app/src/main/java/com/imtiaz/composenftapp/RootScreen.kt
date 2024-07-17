package com.imtiaz.composenftapp

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.size
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.imtiaz.composenftapp.ui.home.HomeScreen
import com.imtiaz.composenftapp.ui.onboarding.OnBoardingScreen
import com.imtiaz.composenftapp.ui.stats.StatsScreen

/**
 *
 * Copyright (c) 2023 tawk.to. All rights reserved.
 *
 * @author Imtiaz Dipto.
 * @since 21/5/23 4:30 PM
 */

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun RootScreen() {
    val navigationController = rememberNavController()
    var shouldShowOnBoarding by rememberSaveable {
        mutableStateOf(true)
    }

    Scaffold(
        bottomBar = {
            if (!shouldShowOnBoarding) {
                BottomBar(navigationController)
            }
        }
    ) {
        NavHost(
            navController = navigationController,
            startDestination =
            if (shouldShowOnBoarding) NavigationItem.Login.route else NavigationItem.Home.route
        ) {

            composable(NavigationItem.Login.route) {
                OnBoardingScreen {
                    navigationController.navigate(NavigationItem.Home.route)
                    shouldShowOnBoarding = false
                }
            }

            composable(NavigationItem.Home.route) {
                HomeScreen()
            }

            composable(NavigationItem.Stats.route) {
                StatsScreen()
            }

            composable(NavigationItem.Add.route) {
                Text(text = "Add")
            }

            composable(NavigationItem.Search.route) {
                Text(text = "Search")
            }

            composable(NavigationItem.Profile.route) {
                Text(text = "Profile")
            }
        }
    }
}

@Composable
fun BottomBar(
    navController: NavController
) {
    val items = listOf<NavigationItem>(
        NavigationItem.Home,
        NavigationItem.Stats,
        NavigationItem.Add,
        NavigationItem.Search,
        NavigationItem.Profile
    )

    BottomNavigation(
        backgroundColor = Color(33, 17, 52),
        contentColor = Color.White
    ) {
        // tracks previous view hierarchy that currently in  navigation stack
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route

        items.forEach { item ->
            BottomNavigationItem(
                icon = {
                    Image(
                        imageVector = item.icon,
                        contentDescription = item.title,
                        modifier = Modifier.size(30.dp),
                        colorFilter = ColorFilter.tint(Color.White)
                    )
                },
                unselectedContentColor = Color.White.copy(alpha = 0.4f),
                selectedContentColor = Color.White,
                alwaysShowLabel = false,
                selected = currentRoute == item.route,
                onClick = {
                    navController.navigate(item.route) {
                        // it pops up the start destination of the graph and set as back stack screen
                        // and avoiding building large stack
                        navController.graph.startDestinationRoute?.let { route ->
                            popUpTo(route) {
                                saveState = true
                            }
                        }
                        // avoid multiple taps on same bottom tab and just show same tab
                        // if that tab pressed when that particular tab already visible
                        launchSingleTop = true

                        // restoring current tab/screen's scrolling state so that
                        // user don't need start from very beginning of the screen
                        // when user came back again to this screen by pressing back button
                        restoreState = true
                    }
                }
            )
        }
    }
}

sealed class NavigationItem(var route: String, var icon: ImageVector, var title: String) {
    object Login : NavigationItem("login", Icons.Filled.Home, "Home")
    object Home : NavigationItem("home", Icons.Filled.Home, "Home")
    object Stats : NavigationItem("stats", Icons.Filled.Analytics, "Stats")
    object Add : NavigationItem("add", Icons.Filled.Add, "Add")
    object Search : NavigationItem("search", Icons.Filled.Search, "Search")
    object Profile : NavigationItem("profile", Icons.Filled.Person, "Profile")
}
