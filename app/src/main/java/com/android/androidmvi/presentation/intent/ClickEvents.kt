package com.android.androidmvi.presentation.intent

sealed class ClickEvents {
    data object ShowResult: ClickEvents()
}