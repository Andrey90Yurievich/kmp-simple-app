package org.company.app.features.login

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import org.company.app.features.login.models.LoginAction
import org.company.app.navigation.LocalNavHost

@Composable
fun LoginScreen(
    navController: NavController,
    loginViewModel: LoginViewModel = viewModel { LoginViewModel() }


) {
    val externalNavHost = LocalNavHost.current
    val viewState by loginViewModel.viewStates().collectAsState() // collectAsState(), которая позволяет получить текущее значение из потока в виде состояния.
    val viewAction by loginViewModel.viewActions().collectAsState(null)

    LoginView(viewState = viewState, navController = navController) { event ->
        loginViewModel.obtainEvent(event)
    }

    when (viewAction) {
        LoginAction.OpenMainScreen -> {
            loginViewModel.clearAction()
        }
        null -> {  }
    }
}