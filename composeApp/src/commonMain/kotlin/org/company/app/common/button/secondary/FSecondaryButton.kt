package org.company.app.common.button.secondary

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults


import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.structuralEqualityPolicy
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.Role.Companion.Button
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kmp_simple_app.composeapp.generated.resources.Res
import org.company.app.theme.FamousColors
import org.company.app.theme.FamousTheme


@Composable
fun FSecondaryButton(
    modifier: Modifier = Modifier,
    text: String,
    enabled: Boolean = true,
    onClick: () -> Unit
) {
    Button(
        modifier = modifier.height(40.dp),
        onClick = onClick,
        enabled = enabled,
        shape = RoundedCornerShape(12.dp),
        colors = ButtonDefaults.buttonColors(
            backgroundColor = FamousTheme.colors.secondaryBackground,
            disabledBackgroundColor = FamousTheme.colors.secondaryBackground
        )
    ) {
        Text(
            text = text,
            color = if (enabled) FamousTheme.colors.primaryText else FamousTheme.colors.tintColor,
            fontSize = 14.sp,
            fontWeight = FontWeight.Bold
            )
    }
}

