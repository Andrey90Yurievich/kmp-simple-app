package org.company.app.features.profile.ui.views

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import org.company.app.theme.FamousTheme

@Composable
fun ProfileAboutView() {
    Text(text = "Hello, About", color = FamousTheme.colors.primaryText)
}