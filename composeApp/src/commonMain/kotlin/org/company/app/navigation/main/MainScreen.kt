package org.company.app.navigation.main

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.MailOutline
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.unit.dp
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import kmp_simple_app.composeapp.generated.resources.Res
import kmp_simple_app.composeapp.generated.resources.bottom_home
import kmp_simple_app.composeapp.generated.resources.bottom_inbox
import kmp_simple_app.composeapp.generated.resources.bottom_library
import kmp_simple_app.composeapp.generated.resources.bottom_post
import kmp_simple_app.composeapp.generated.resources.bottom_subscriptions
import org.company.app.features.feed.FeedScreen
import org.company.app.features.profile.ui.ProfileScreen
import org.company.app.features.profile.ui.ProfileView
import org.company.app.navigation.AppScreens
import org.company.app.navigation.LocalNavHost
import org.company.app.theme.FamousTheme
import org.jetbrains.compose.resources.stringResource

enum class MainScreens(val route: String) {
    Home("home"), Subscriptions("subscriptions"), Post("post"), Inbox("inbox"), Library("library")
}

@Composable
fun MainScreen() {
    val outerNavController = LocalNavHost.current
    val navController = rememberNavController()
    val items = MainScreens.entries.toTypedArray() //entries - Возвращает набор всех пар ключ/ значение в этой карте, доступный только для чтения.
                                                    //toTypedArray - Возвращает типизированный массив объектов, содержащий все элементы этого примитивного массива.
    val bottomNavigationHeight = 75.dp

    Box(modifier = Modifier.fillMaxSize()) {
        NavHost(
            navController,
            modifier = Modifier
                .padding(bottom = bottomNavigationHeight)
                .fillMaxHeight(),
            startDestination = MainScreens.Home.route
        ) {
            composable(MainScreens.Home.route) { FeedScreen() }
            composable(MainScreens.Subscriptions.route) { ProfileScreen() }
            composable(MainScreens.Inbox.route) { Text("Hello, Inbox") }
            composable(MainScreens.Library.route) { Text("Hello, Lobrary") }

        }

        BottomNavigation(
            modifier = Modifier.align(Alignment.BottomStart).fillMaxWidth()
                .height(bottomNavigationHeight),
            backgroundColor = FamousTheme.colors.secondaryBackground
        ) {
            val navBackStackEntry by navController.currentBackStackEntryAsState()
            val currentDestination = navBackStackEntry?.destination

            items.forEach { screen ->
                val isSelected = currentDestination?.hierarchy?.any { it.route == screen.route } == true

                BottomNavigationItem(
                    icon = {
                        Icon(
                            imageVector = when (screen) {
                                MainScreens.Home -> Icons.Filled.Home
                                MainScreens.Subscriptions -> Icons.Filled.Check
                                MainScreens.Post -> Icons.Filled.Add
                                MainScreens.Inbox -> Icons.Filled.MailOutline
                                MainScreens.Library -> Icons.Filled.AccountBox
                            },
                            contentDescription = screen.route,
                            tint = if (isSelected) FamousTheme.colors.primaryText else FamousTheme.colors.tintColor,
                        )
                    },
                    label = {
                            Text(
                                text = stringResource(
                                when (screen) {
                                    MainScreens.Home -> Res.string.bottom_home
                                    MainScreens.Subscriptions -> Res.string.bottom_subscriptions
                                    MainScreens.Post -> Res.string.bottom_post
                                    MainScreens.Inbox -> Res.string.bottom_inbox
                                    MainScreens.Library -> Res.string.bottom_library
                                }),
                                color = if(isSelected) FamousTheme.colors.primaryText else FamousTheme.colors.tintColor,

                            )
                    },
                    selected = isSelected,
                    onClick = {
                        if (screen == MainScreens.Post) {
                            outerNavController.navigate(AppScreens.CreatePost.title)
                        } else {
                            navController.navigate(screen.route) {
                                popUpTo(navController.graph.findStartDestination().displayName) {
                                    saveState = true
                                }
                                launchSingleTop = true
                                restoreState = true
                            }
                        }
                    },
                )
            }
        }
    }
}