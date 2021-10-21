package com.example.itrueque.ui.view.login

import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Close
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.BottomCenter
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.itrueque.Destinations
import com.example.itrueque.R
import com.example.itrueque.ui.component.button.ITruequeEmailButton
import com.example.itrueque.ui.component.button.ITruequeGoogleButton
import com.example.itrueque.ui.component.button.ITruequeLoginButton
import com.example.itrueque.ui.component.modal.ModalBottomSheet
import com.example.itrueque.ui.component.text.iTruequeInput
import com.example.itrueque.ui.component.text.iTruequeInputPassword
import com.example.itrueque.ui.theme.Shapes
import com.example.itrueque.ui.theme.TurquoiseBlack
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@ExperimentalComposeUiApi
@ExperimentalMaterialApi
@Composable
fun LoginScreen(navController: NavController) {
    val viewModel: LoginViewModel = hiltViewModel()

    var loading by remember { mutableStateOf(false) }

    loading = viewModel.event.collectAsState().value is LoginViewModel.UIEvent.Loading

    when (val event = viewModel.event.collectAsState().value) {
        is LoginViewModel.UIEvent.Error -> {
            Toast.makeText(
                LocalContext.current,
                when (event.error) {
                    LoginViewModel.LoginError.EMPTY_FIELD_ERROR -> stringResource(R.string.empty_error_title)
                    LoginViewModel.LoginError.CREDENTIAL_ERROR -> stringResource(R.string.credential_error_title)
                },
                Toast.LENGTH_SHORT
            ).show()
        }
        is LoginViewModel.UIEvent.SuccessLogin -> {
            navController.navigate(Destinations.HOME_ROUTE)
        }
        is LoginViewModel.UIEvent.SuccessSignUp -> {
            viewModel.login(event.email, event.password)
        }
    }

    viewModel.loadData()
    LoginView(
        loading = loading,
        login = {
            viewModel.login(email = it.first, password = it.second)
        },
        signUp = {
            viewModel.signUp(email = it.first, password = it.second)
        })
}

@ExperimentalComposeUiApi
@ExperimentalMaterialApi
@Composable
fun LoginView(
    loading: Boolean,
    login: (Pair<String, String>) -> Unit,
    signUp: (Pair<String, String>) -> Unit
) {

    var isLogin by remember { mutableStateOf(true) }

    val modalBottomSheetState = rememberModalBottomSheetState(
        initialValue = ModalBottomSheetValue.Hidden
    )
    val scope = rememberCoroutineScope()

    ModalBottomSheet(
        bottomSheetContent = {
            if (isLogin) {
                LoginView(
                    loading = loading,
                    login = {
                        login(it)
                    },
                    modalBottomSheetState = modalBottomSheetState,
                    scope = scope
                )
            } else {
                SignUpView(
                    loading = loading,
                    signUp = {
                        signUp(it)
                    },
                    modalBottomSheetState = modalBottomSheetState,
                    scope = scope
                )
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
                        .align(BottomCenter)
                ) {
                    ITruequeGoogleButton {
                        // OnClick
                    }

                    Spacer(modifier = Modifier.height(16.dp))

                    ITruequeEmailButton {
                        scope.launch {
                            isLogin = false
                            modalBottomSheetState.animateTo(ModalBottomSheetValue.Expanded)
                        }
                    }

                    Spacer(modifier = Modifier.height(32.dp))

                    ITruequeLoginButton(
                        modifier = Modifier.fillMaxWidth(),
                        firstText = stringResource(R.string.has_account_text),
                        secondText = stringResource(R.string.login_text)
                    ) {
                        scope.launch {
                            isLogin = true
                            modalBottomSheetState.animateTo(ModalBottomSheetValue.Expanded)
                        }
                    }
                }
            }
        }, sheetState = modalBottomSheetState
    )
}

@ExperimentalMaterialApi
@ExperimentalComposeUiApi
@Composable
fun LoginView(
    loading: Boolean,
    login: (Pair<String, String>) -> Unit,
    modalBottomSheetState: ModalBottomSheetState,
    scope: CoroutineScope
) {

    var email = ""
    var password = ""
    val (focusRequester) = FocusRequester.createRefs()

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 32.dp, bottom = 8.dp, start = 16.dp, end = 16.dp)
    ) {
        Column(Modifier.fillMaxWidth()) {

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
            ) {
                Text(
                    text = stringResource(R.string.welcome_title),
                    fontSize = 32.sp,
                    fontWeight = FontWeight.ExtraBold,
                    modifier = Modifier.width(200.dp)
                )
                IconButton(
                    onClick = {
                        scope.launch { modalBottomSheetState.animateTo(ModalBottomSheetValue.Hidden) }
                    }) {
                    Image(
                        imageVector = Icons.Outlined.Close,
                        contentDescription = "Close icon"
                    )
                }
            }

            LazyColumn(
                modifier = Modifier.padding(top = 40.dp),
                horizontalAlignment = CenterHorizontally
            ) {
                item {

                    email = iTruequeInput(
                        modifier = Modifier.fillMaxWidth(),
                        label = stringResource(R.string.email_title),
                        keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next),
                        focusRequester = focusRequester
                    )

                    Spacer(modifier = Modifier.height(10.dp))

                    password = iTruequeInputPassword(
                        modifier = Modifier
                            .fillMaxWidth()
                            .focusRequester(focusRequester),
                        label = stringResource(R.string.password_title),
                        keyboardOptions = KeyboardOptions(imeAction = ImeAction.Done),
                    )

                    Spacer(modifier = Modifier.height(32.dp))

                    if (loading) CircularProgressIndicator()
                }
            }
        }

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .align(BottomCenter)
        ) {
            OutlinedButton(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(48.dp),
                elevation = ButtonDefaults.elevation(defaultElevation = 0.dp),
                contentPadding = PaddingValues(all = 8.dp),
                border = BorderStroke(1.dp, MaterialTheme.colors.primary),
                colors = ButtonDefaults.outlinedButtonColors(contentColor = MaterialTheme.colors.primary),
                shape = Shapes.medium,
                onClick = {
                    login(Pair(email, password))
                }
            ) {
                Text(text = stringResource(R.string.login_title))
            }

            Text(
                text = stringResource(R.string.forget_password_title),
                modifier = Modifier
                    .align(CenterHorizontally)
                    .padding(8.dp),
                fontSize = 14.sp,
                color = Color.Gray
            )
        }
    }
}

@ExperimentalMaterialApi
@ExperimentalComposeUiApi
@Composable
fun SignUpView(
    loading: Boolean,
    signUp: (Pair<String, String>) -> Unit,
    modalBottomSheetState: ModalBottomSheetState,
    scope: CoroutineScope
) {

    var name = ""
    var email = ""
    var password = ""

    val (focusRequester) = FocusRequester.createRefs()

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 32.dp, bottom = 8.dp, start = 16.dp, end = 16.dp)
    ) {
        Column(Modifier.fillMaxWidth()) {

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
            ) {
                Text(
                    text = stringResource(R.string.signup_title),
                    fontSize = 32.sp,
                    fontWeight = FontWeight.ExtraBold,
                    modifier = Modifier.width(200.dp)
                )
                IconButton(
                    onClick = {
                        scope.launch { modalBottomSheetState.animateTo(ModalBottomSheetValue.Hidden) }
                    }) {
                    Image(
                        imageVector = Icons.Outlined.Close,
                        contentDescription = "Close icon"
                    )
                }
            }

            LazyColumn(
                modifier = Modifier.padding(top = 40.dp),
                horizontalAlignment = CenterHorizontally
            ) {
                item {

                    name = iTruequeInput(
                        modifier = Modifier.fillMaxWidth(),
                        label = stringResource(R.string.name_title),
                        keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next),
                        focusRequester = focusRequester
                    )

                    Spacer(modifier = Modifier.height(10.dp))

                    email = iTruequeInput(
                        modifier = Modifier.fillMaxWidth(),
                        label = stringResource(R.string.email_title),
                        keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next),
                        focusRequester = focusRequester
                    )

                    Spacer(modifier = Modifier.height(10.dp))

                    password = iTruequeInputPassword(
                        modifier = Modifier
                            .fillMaxWidth()
                            .focusRequester(focusRequester),
                        label = stringResource(R.string.password_title),
                        keyboardOptions = KeyboardOptions(imeAction = ImeAction.Done),
                    )

                    Spacer(modifier = Modifier.height(32.dp))

                    if (loading) CircularProgressIndicator()
                }
            }
        }

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .align(BottomCenter)
                .padding(8.dp)
        ) {
            OutlinedButton(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(48.dp),
                elevation = ButtonDefaults.elevation(defaultElevation = 0.dp),
                contentPadding = PaddingValues(all = 8.dp),
                border = BorderStroke(1.dp, MaterialTheme.colors.primary),
                colors = ButtonDefaults.outlinedButtonColors(contentColor = MaterialTheme.colors.primary),
                shape = Shapes.medium,
                onClick = {
                    signUp(Pair(email, password))
                }
            ) {
                Text(text = stringResource(R.string.signup_button_title))
            }
        }
    }
}


@ExperimentalComposeUiApi
@ExperimentalMaterialApi
@Preview
@Composable
fun LoginViewPreview() {
    LoginView(
        loading = true,
        login = {

        },
        signUp = {

        }
    )
}