package com.example.itrueque.ui.view.login

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.itrueque.domain.usecase.LoginUseCase
import com.example.itrueque.domain.usecase.SignUpUseCase
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
    @Named("signUp") private val signUpUC: SignUpUseCase,
) : ViewModel() {

    enum class LoginError {
        EMPTY_FIELD_ERROR, CREDENTIAL_ERROR
    }

    sealed class UIEvent {
        object Normal : UIEvent()
        object Loading : UIEvent()
        object SuccessLogin : UIEvent()
        class Error(val error: LoginError) : UIEvent()
        class SuccessSignUp(val email: String, val password: String) : UIEvent()
    }

    private var _event: MutableStateFlow<UIEvent> = MutableStateFlow(UIEvent.Normal)
    val event: StateFlow<UIEvent?>
        get() = _event

    init {

    }

    fun loadData() {

    }

    fun login(email: String, password: String) {
        _event.value = UIEvent.Loading

        if (email.isBlank() || password.isBlank()) {
            _event.value = UIEvent.Error(LoginError.EMPTY_FIELD_ERROR)
            return
        }

        viewModelScope.launch(Dispatchers.IO) {
            val task = loginUC.execute(email = email, password = password)
            task.addOnCompleteListener { result ->
                if (result.isSuccessful) {
                    _event.value = UIEvent.SuccessLogin
                } else {
                    _event.value = UIEvent.Error(LoginError.CREDENTIAL_ERROR)
                }
            }
        }
    }

    fun signUp(email: String, password: String) {
        _event.value = UIEvent.Loading

        if (email.isBlank() || password.isBlank()) {
            _event.value = UIEvent.Error(LoginError.EMPTY_FIELD_ERROR)
            return
        }

        viewModelScope.launch(Dispatchers.IO) {
            val task = signUpUC.execute(email = email, password = password)
            task.addOnCompleteListener { result ->
                if (result.isSuccessful) {
                    _event.value = UIEvent.SuccessSignUp(email = email, password = password)
                } else {
                    _event.value = UIEvent.Error(LoginError.CREDENTIAL_ERROR)
                }
            }
        }
    }
}