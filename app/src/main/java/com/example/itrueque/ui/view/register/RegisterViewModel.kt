package com.example.itrueque.ui.view.register

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.itrueque.domain.usecase.LoginUseCase
import com.example.itrueque.ui.view.login.LoginViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject
import javax.inject.Named

@HiltViewModel
class RegisterViewModel
@Inject constructor(
    private val savedStateHandle: SavedStateHandle,
    @Named("register") private val loginUC: LoginUseCase,
) : ViewModel() {

    enum class RegisterError {
        EMPTY_FIELD_ERROR
    }

    sealed class UIEvent {
        object Loading : UIEvent()
        object SuccessRegister : UIEvent()
        class  ErrorRegister(val error: RegisterError) : UIEvent()
    }

    private var _event: MutableStateFlow<UIEvent> = MutableStateFlow(UIEvent.Loading)
    val event: StateFlow<UIEvent?>
        get() = _event

    init {

    }

    fun loadData() {

    }

    fun register(email: String, password: String) {

        if(email.isBlank() || password.isBlank()) {
            _event.value = UIEvent.ErrorRegister(RegisterError.EMPTY_FIELD_ERROR)
            return
        }

        viewModelScope.launch(Dispatchers.IO) {
            val task = loginUC.execute(email = email, password = password)
            task.addOnCompleteListener { result ->
                if (result.isSuccessful) {
                    _event.value = UIEvent.SuccessRegister
                } else {
                //    _event.value = UIEvent.ErrorRegister(RegisterViewModel.RegisterError.CREDENTIAL_ERROR)
                }
            }
        }
    }
}