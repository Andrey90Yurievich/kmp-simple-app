package org.company.app.features.profile.presentation.models

sealed class ProfileEvent {
    class TabSelected(val selectedIndex: Int) : ProfileEvent()
}