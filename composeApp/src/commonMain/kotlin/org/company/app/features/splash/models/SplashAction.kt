package org.company.app.features.splash.models

sealed class SplashAction {
    data object ShowMainScreen : SplashAction()
    data object ShowLoginScreen : SplashAction()
}