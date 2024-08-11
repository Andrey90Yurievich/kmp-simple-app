package org.company.app.features.profile.ui

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kmp_simple_app.composeapp.generated.resources.Res
import kmp_simple_app.composeapp.generated.resources.login_title
import kmp_simple_app.composeapp.generated.resources.profile_about
import kmp_simple_app.composeapp.generated.resources.profile_playylists
import kmp_simple_app.composeapp.generated.resources.profile_subscribe
import kmp_simple_app.composeapp.generated.resources.profile_subscribed
import kmp_simple_app.composeapp.generated.resources.profile_title
import kmp_simple_app.composeapp.generated.resources.profile_videos
import org.company.app.common.button.secondary.FSecondaryButton
import org.company.app.features.profile.presentation.models.ProfileEvent
import org.company.app.features.profile.presentation.models.ProfileViewState
import org.company.app.features.profile.ui.views.ProfileAboutView
import org.company.app.features.profile.ui.views.ProfilePlayListView
import org.company.app.features.profile.ui.views.ProfileTabsView
import org.company.app.features.profile.ui.views.ProfileVideosView
import org.company.app.theme.FamousColors
import org.company.app.theme.FamousTheme
import org.jetbrains.compose.resources.stringResource

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ProfileView(
    viewState: ProfileViewState,
    eventHandler: (ProfileEvent) -> Unit
) {
    LazyColumn {
        stickyHeader {
            Box(modifier = Modifier.fillMaxWidth().height(72.dp)
                .padding(start = 16.dp, end = 16.dp, top = 16.dp, bottom = 8.dp)
            ) {
                Text(
                    modifier = Modifier.fillMaxWidth(),
                    text = stringResource(Res.string.profile_title),
                    color = FamousTheme.colors.primaryText,
                    textAlign = TextAlign.Center,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold
                )
            }

            Box(
                modifier = Modifier
                    .padding(16.dp)
                    .clip(RoundedCornerShape(64.dp))
                    .size(128.dp)
                    .background(Color.White)

            )

            Column(
                modifier = Modifier.padding(16.dp)
            ) {
                Text(
                    text = viewState.name,
                    color = FamousTheme.colors.primaryText,
                    fontSize = 22.sp,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = viewState.name,
                    color = FamousTheme.colors.tintColor,
                    fontSize = 16.sp
                )
                Text(
                    text = viewState.name,
                    color = FamousTheme.colors.tintColor,
                    fontSize = 16.sp
                )
            }

        }


        if (viewState.isSubscribed != null) {

            item {
                FSecondaryButton(
                    modifier = Modifier
                        .padding(16.dp)
                        .fillMaxWidth(),
                    text = stringResource(if (viewState.isSubscribed == false) Res.string.profile_subscribe else Res.string.profile_subscribed)
                ) {

                }
            }
        }

        item {
            ProfileTabsView(
                items = listOf(
                    stringResource(Res.string.profile_videos),
                    stringResource(Res.string.profile_playylists),
                    stringResource(Res.string.profile_about),
                ),
                selectedIndex = viewState.selectedTabIndex
            ) {
                eventHandler.invoke(ProfileEvent.TabSelected(it))
            }
        }

        item {
            Box(
                modifier = Modifier.padding(16.dp).fillMaxWidth()
            ) {
                when (viewState.selectedTabIndex) {
                    0 -> ProfileVideosView()
                    1 -> ProfilePlayListView()
                    2 -> ProfileAboutView()
                }
            }
        }
    }
}