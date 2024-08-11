package org.company.app.features.login

import org.company.app.base.BaseViewModel
import org.company.app.features.login.models.LoginAction
import org.company.app.features.login.models.LoginEvent
import org.company.app.features.login.models.LoginViewState

class LoginViewModel: BaseViewModel<LoginViewState, LoginAction, LoginEvent>(initialState = LoginViewState()) {
    override fun obtainEvent(viewEvent: LoginEvent) {
        when(viewEvent) {
            is LoginEvent.EmailChanged -> viewState = viewState.copy(emailValue = viewEvent.newValue)
            is LoginEvent.PasswordChanged -> viewState = viewState.copy(passwordValue = viewEvent.newValue)
        }

    }
}