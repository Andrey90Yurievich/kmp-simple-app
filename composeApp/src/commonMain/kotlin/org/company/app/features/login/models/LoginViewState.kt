package org.company.app.features.login.models

data class LoginViewState(
    val emailValue: String = "",
    val passwordValue: String = "",
    val isSending: Boolean = false
) {
}