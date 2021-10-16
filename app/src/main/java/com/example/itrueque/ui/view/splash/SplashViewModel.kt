package com.example.itrueque.ui.view.splash

import androidx.lifecycle.*
import com.example.itrueque.domain.usecase.HasNeedLoginUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SplashViewModel
@Inject constructor(
    private val savedStateHandle: SavedStateHandle,
    private val hasNeedLoginUC: HasNeedLoginUseCase,
) : ViewModel() {

    private val _needLogin = MutableLiveData(false)
    val needLogin: LiveData<Boolean> = _needLogin

    init {

    }

    fun loadData() {
        viewModelScope.launch {
            _needLogin.value = hasNeedLoginUC.execute()
        }
    }
}