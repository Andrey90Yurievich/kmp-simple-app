package org.company.app.features.login


import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.key.Key.Companion.R
import androidx.compose.ui.input.pointer.PointerIcon
import androidx.compose.ui.input.pointer.PointerIcon.Companion.Text
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.KeyboardType.Companion.Text
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import kmp_simple_app.composeapp.generated.resources.Res
import kmp_simple_app.composeapp.generated.resources.login_email
import kmp_simple_app.composeapp.generated.resources.login_forgot
import kmp_simple_app.composeapp.generated.resources.login_intro
import kmp_simple_app.composeapp.generated.resources.login_login
import kmp_simple_app.composeapp.generated.resources.login_password
import kmp_simple_app.composeapp.generated.resources.login_register
import kmp_simple_app.composeapp.generated.resources.login_signup
import kmp_simple_app.composeapp.generated.resources.login_title
import kmp_simple_app.composeapp.generated.resources.login_welcome_back
import org.company.app.common.textfield.FTextField
import org.company.app.features.login.models.LoginEvent
import org.company.app.features.login.models.LoginViewState
import org.company.app.navigation.AppScreens
import org.company.app.theme.FamousTheme
import org.jetbrains.compose.resources.stringResource

@Composable
internal fun LoginView(
    navController: NavController,
    viewState: LoginViewState,
    eventHandler: (LoginEvent) -> Unit

) {
    Column {
        Box(
            modifier = Modifier
                .padding(top = 16.dp, bottom = 8.dp)
                .fillMaxWidth()
                .height(48.dp)
        ) {
            Text(
                modifier = Modifier.align(Alignment.Center),
                text = stringResource(Res.string.login_title),
                textAlign = TextAlign.Center,
                color = FamousTheme.colors.primaryText,
                fontWeight = FontWeight.Bold, fontSize = 18.sp
            )
        }

        Box(modifier = Modifier
            .padding(top = 20.dp, bottom = 12.dp)
            .fillMaxWidth()
            .height(28.dp)
        ) {
            Text(
                modifier = Modifier.align(Alignment.Center),
                text = stringResource(Res.string.login_welcome_back),
                textAlign = TextAlign.Center,
                color = FamousTheme.colors.primaryText,
                fontWeight = FontWeight.Bold, fontSize = 22.sp
            )
        }

        Box(modifier = Modifier
            .padding(top = 4.dp, bottom = 12.dp, start = 16.dp, end = 16.dp)
            .fillMaxWidth()
        ) {
            Text(
                modifier = Modifier.align(Alignment.Center),
                text = stringResource(Res.string.login_intro),
                textAlign = TextAlign.Center,
                color = FamousTheme.colors.primaryText,
                fontWeight = FontWeight.Normal, fontSize = 16.sp
            )
        }

        FTextField(
            text = viewState.emailValue,
            hint = stringResource(Res.string.login_email),
            enabled = !viewState.isSending
        ) {
            eventHandler.invoke(LoginEvent.EmailChanged(it))
        }
        FTextField(
            text = viewState.passwordValue,
            hint = stringResource(Res.string.login_password),
            enabled = !viewState.isSending
        ) {
            eventHandler.invoke(LoginEvent.PasswordChanged(it))
        }

        Row(
            modifier = Modifier.padding(horizontal = 16.dp, vertical = 12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier.size(width = 156.dp, height = 40.dp)
                    .clickable {


                    }) {
                Text(
                    modifier = Modifier.align(Alignment.Center),
                    text = stringResource(Res.string.login_forgot),
                    color = FamousTheme.colors.primaryText)
            }

            Spacer(modifier = Modifier.weight(1f))
            Box(
                modifier = Modifier
                    .size(width = 84.dp, height = 40.dp)
                    .clickable {
                        navController.navigate(route = AppScreens.Main.title)
                    },
            ) {
                Text(
                    modifier = Modifier.align(Alignment.Center),
                    text = stringResource(Res.string.login_login),
                    color = FamousTheme.colors.primaryText)
            }
        }

        Row {
            Text(
                modifier = Modifier.padding(top = 4.dp, bottom = 12.dp, start = 16.dp),
                text = stringResource(Res.string.login_register),
                color = FamousTheme.colors.tintColor,
                fontWeight = FontWeight.Light
            )

            Text(
                modifier = Modifier.padding(top = 4.dp, bottom = 12.dp, end = 16.dp)
                    .clickable {

                    },
                text = stringResource(Res.string.login_signup),
                color = FamousTheme.colors.tintColor,
                fontWeight = FontWeight.Light
            )
        }
    }
}
