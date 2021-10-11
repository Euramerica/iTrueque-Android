package com.example.itrueque.ui.view.login

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.ModalBottomSheetValue
import androidx.compose.material.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.itrueque.R
import com.example.itrueque.ui.component.button.ITruequeEmailButton
import com.example.itrueque.ui.component.button.ITruequeGoogleButton
import com.example.itrueque.ui.component.button.ITruequeLoginButton
import com.example.itrueque.ui.component.modal.ModalBottomSheet
import com.example.itrueque.ui.component.text.iTruequeInput
import com.example.itrueque.ui.theme.TurquoiseBlack
import kotlinx.coroutines.launch

@ExperimentalComposeUiApi
@ExperimentalMaterialApi
@Composable
fun LoginScreen() {
    val viewModel: LoginViewModel = hiltViewModel()

    viewModel.loadData()
    LoginView()
}

@ExperimentalComposeUiApi
@ExperimentalMaterialApi
@Composable
fun LoginView() {

    val modalBottomSheetState = rememberModalBottomSheetState(
        initialValue = ModalBottomSheetValue.Hidden
    )
    val scope = rememberCoroutineScope()

    ModalBottomSheet(
        bottomSheetContent = {
            val (focusRequester) = FocusRequester.createRefs()

            LazyColumn {
                item {

                    val email = iTruequeInput(
                        modifier = Modifier.fillMaxWidth(),
                        label = "Correo electronico",
                        keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next),
                        focusRequester = focusRequester
                    )

                    val password = iTruequeInput(
                        modifier = Modifier
                            .fillMaxWidth()
                            .focusRequester(focusRequester),
                        label = "Contraseña",
                        keyboardOptions = KeyboardOptions(imeAction = ImeAction.Done),
                    )
                }
            }
        },
        contentBehind = {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(TurquoiseBlack)
            ) {

                Image(
                    painter = painterResource(id = R.drawable.background_login),
                    contentDescription = stringResource(R.string.login_background_description),
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.fillMaxSize()
                )

                Image(
                    painter = painterResource(id = R.drawable.itrueque_name_icon),
                    contentDescription = "App name icon",
                    modifier = Modifier
                        .align(Alignment.TopCenter)
                        .padding(top = 56.dp)
                        .size(300.dp)
                )

                Column(
                    modifier = Modifier
                        .padding(start = 16.dp, end = 16.dp, bottom = 40.dp)
                        .align(Alignment.BottomCenter)
                ) {
                    ITruequeGoogleButton {
                        // OnClick
                    }

                    Spacer(modifier = Modifier.height(16.dp))

                    ITruequeEmailButton {
                        // OnClick
                    }

                    Spacer(modifier = Modifier.height(32.dp))

                    ITruequeLoginButton(
                        modifier = Modifier.fillMaxWidth(),
                        firstText = stringResource(R.string.has_account_text),
                        secondText = stringResource(R.string.login_text)
                    ) {
                        scope.launch {
                            modalBottomSheetState.show()
                        }
                    }
                }
            }
        }, sheetState = modalBottomSheetState
    )
}


@ExperimentalComposeUiApi
@ExperimentalMaterialApi
@Preview
@Composable
fun LoginViewPreview() {
    LoginView()
}