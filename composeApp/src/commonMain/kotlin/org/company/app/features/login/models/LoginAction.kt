package org.company.app.features.login.models

sealed class LoginAction {
    data object OpenMainScreen : LoginAction()
}