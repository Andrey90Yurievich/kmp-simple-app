package org.company.app.features.splash

import org.company.app.base.BaseViewModel
import org.company.app.features.login.domain.IsUserAuthhorizedUseCase
import org.company.app.features.splash.models.SplashAction

class SplashViewModel(
    private val isUserAuthhorizedUseCase: IsUserAuthhorizedUseCase = IsUserAuthhorizedUseCase()
): BaseViewModel<Unit, SplashAction, Unit>(
    initialState = Unit
) {
    init {
        checkUserAuthorized()
    }

    override fun obtainEvent(viewEvent: Unit) {
        TODO("Not yet implemented")
    }

    private fun checkUserAuthorized() {
        viewAction = if (isUserAuthhorizedUseCase.execute()) {
            SplashAction.ShowLoginScreen
        } else {
            SplashAction.ShowLoginScreen
        }

    }
}