package org.company.app.features.login.models

sealed class LoginEvent {
    class EmailChanged(val newValue: String) : LoginEvent()
    class PasswordChanged(val newValue: String) : LoginEvent()
}