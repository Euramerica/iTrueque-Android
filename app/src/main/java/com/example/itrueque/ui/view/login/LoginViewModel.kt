package com.example.itrueque.ui.view.login

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.itrueque.domain.usecase.LoginUseCase
import com.google.firebase.auth.FirebaseUser
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject
import javax.inject.Named


@HiltViewModel
class LoginViewModel
@Inject constructor(
    private val savedStateHandle: SavedStateHandle,
    @Named("login") private val loginUC: LoginUseCase,
) : ViewModel() {

    enum class LoginError {
        EMPTY_FIELD_ERROR, CREDENTIAL_ERROR
    }

    sealed class UIEvent {
        object Loading : UIEvent()
        object SuccessLogin : UIEvent()
        class ErrorLogin(val error: LoginError) : UIEvent()
    }

    private var _event: MutableStateFlow<UIEvent> = MutableStateFlow(UIEvent.Loading)
    val event: StateFlow<UIEvent?>
        get() = _event

    init {

    }

    fun loadData() {

    }

    fun login(email: String, password: String) {

        if(email.isBlank() || password.isBlank()) {
            _event.value = UIEvent.ErrorLogin(LoginError.EMPTY_FIELD_ERROR)
            return
        }

        viewModelScope.launch(Dispatchers.IO) {
            val task = loginUC.execute(email = email, password = password)
            task.addOnCompleteListener { result ->
                if (result.isSuccessful) {
                    _event.value = UIEvent.SuccessLogin
                } else {
                    _event.value = UIEvent.ErrorLogin(LoginError.CREDENTIAL_ERROR)
                }
            }
        }
    }
}