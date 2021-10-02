package com.example.itrueque.ui.view.splash

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SplashViewModel
@Inject constructor(
    private val savedStateHandle: SavedStateHandle
) : ViewModel() {

    init {

    }

    fun loadData() {

    }
}