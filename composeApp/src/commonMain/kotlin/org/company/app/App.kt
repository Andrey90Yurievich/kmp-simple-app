package org.company.app


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import org.company.app.features.create.CreatePostScreen
import org.company.app.features.login.LoginScreen
import org.company.app.features.payWall.PaywallScreen
import org.company.app.features.splash.SplashScreen
import org.company.app.navigation.AppScreens
import org.company.app.navigation.LocalNavHost
import org.company.app.navigation.main.MainScreen
import org.company.app.theme.AppTheme
import org.company.app.theme.FamousColors
import org.company.app.theme.FamousTheme

@Composable
internal fun App() = AppTheme {
        FamousApp()
}

@Composable
internal fun FamousApp(
    navController: NavHostController = rememberNavController()
) {
    val backStackEntry by navController.currentBackStackEntryAsState()
    val currentScreen = backStackEntry?.destination?.route ?: AppScreens.Login.title

    CompositionLocalProvider(
        LocalNavHost provides navController
    ) {
        NavHost(
            navController = navController,
            startDestination = AppScreens.Splash.title
        ) {
            composable(route = AppScreens.Splash.title) {
                SplashScreen(navController = navController)
            }


            composable(route = AppScreens.Login.title) {
                LoginScreen(navController = navController)
            }

            composable(route = AppScreens.Main.title) {
                MainScreen()
            }

            composable(route = AppScreens.CreatePost.title) {
                CreatePostScreen()
            }

            composable(route = AppScreens.Paywall.title) {
                PaywallScreen()

            }



        }
    }
}
