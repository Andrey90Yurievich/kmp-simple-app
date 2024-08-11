package org.company.app.features.profile.presentation

import org.company.app.base.BaseViewModel
import org.company.app.features.profile.presentation.models.ProfileAction
import org.company.app.features.profile.presentation.models.ProfileEvent
import org.company.app.features.profile.presentation.models.ProfileViewState

class ProfileViewModel(

): BaseViewModel<ProfileViewState, ProfileAction, ProfileEvent>(initialState = ProfileViewState(
    name = "Natalie",
    subscribers = "5.3m subscribers",
    joinedIn = "Joined in 2017"
)) {
    override fun obtainEvent(viewEvent: ProfileEvent) {
        when(viewEvent) {
            is ProfileEvent.TabSelected -> viewState = viewState.copy(selectedTabIndex = viewEvent.selectedIndex)
        }
    }
}