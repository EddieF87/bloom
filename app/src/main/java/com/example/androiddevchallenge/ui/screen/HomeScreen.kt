/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.androiddevchallenge.ui.screen

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.KEY_ROUTE
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.navigate
import androidx.navigation.compose.rememberNavController
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.ui.screen.home.CartTab
import com.example.androiddevchallenge.ui.screen.home.FavoritesTab
import com.example.androiddevchallenge.ui.screen.home.HomeTab
import com.example.androiddevchallenge.ui.screen.home.ProfileTab
import dev.chrisbanes.accompanist.insets.navigationBarsPadding
import dev.chrisbanes.accompanist.insets.statusBarsPadding

@Composable
fun HomeScreen(mainNavController: NavHostController) {
    val homeNavController = rememberNavController()
    val items = listOf(
        BottomNavScreen.Home,
        BottomNavScreen.Favorites,
        BottomNavScreen.Profile,
        BottomNavScreen.Cart,
    )
    Scaffold(
        bottomBar = {
            BottomNavigation(
                backgroundColor = MaterialTheme.colors.primary,
                contentColor = MaterialTheme.colors.onPrimary,
                elevation = 16.dp,
                modifier = Modifier.navigationBarsPadding()
            ) {
                val navBackStackEntry by homeNavController.currentBackStackEntryAsState()
                val currentRoute = navBackStackEntry?.arguments?.getString(KEY_ROUTE)
                items.forEach { screen ->
                    BottomNavigationItem(
                        icon = { Icon(painter = painterResource(id = screen.icon), "") },
                        label = { Text(stringResource(screen.label)) },
                        selected = currentRoute == screen.route,
                        onClick = {
                            homeNavController.navigate(screen.route) {
                                popUpTo = homeNavController.graph.startDestination
                                launchSingleTop = true
                            }
                        }
                    )
                }
            }
        }
    ) {
        Box(
            modifier = Modifier
                .statusBarsPadding()
                .padding(it)
        ) {
            NavHost(homeNavController, startDestination = BottomNavScreen.Home.route) {
                composable(BottomNavScreen.Home.route) { HomeTab(homeNavController) }
                composable(BottomNavScreen.Favorites.route) { FavoritesTab(homeNavController) }
                composable(BottomNavScreen.Profile.route) { ProfileTab(homeNavController) }
                composable(BottomNavScreen.Cart.route) { CartTab(homeNavController) }
            }
        }
    }
}

sealed class BottomNavScreen(
    val route: String,
    @DrawableRes val icon: Int,
    @StringRes val label: Int
) {
    object Home : BottomNavScreen("home", icon = R.drawable.ic_home, label = R.string.home_tab_home)
    object Favorites : BottomNavScreen(
        "favorites",
        icon = R.drawable.ic_favorite_border,
        label = R.string.home_tab_favorites
    )

    object Profile : BottomNavScreen(
        "profile",
        icon = R.drawable.ic_account_circle,
        label = R.string.home_tab_profile
    )

    object Cart :
        BottomNavScreen("cart", icon = R.drawable.ic_shopping_cart, label = R.string.home_tab_cart)
}
