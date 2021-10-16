package com.example.itrueque.ui.view.login

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Close
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.BottomCenter
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.itrueque.R
import com.example.itrueque.ui.component.button.ITruequeEmailButton
import com.example.itrueque.ui.component.button.ITruequeGoogleButton
import com.example.itrueque.ui.component.button.ITruequeLoginButton
import com.example.itrueque.ui.component.modal.ModalBottomSheet
import com.example.itrueque.ui.component.text.iTruequeInput
import com.example.itrueque.ui.component.text.iTruequeInputPassword
import com.example.itrueque.ui.theme.Shapes
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
                            text = "¡Te damos la bienvenida!",
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

                    LazyColumn(modifier = Modifier.padding(top = 40.dp)) {
                        item {

                            val email = iTruequeInput(
                                modifier = Modifier.fillMaxWidth(),
                                label = "Correo electronico",
                                keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next),
                                focusRequester = focusRequester
                            )

                            Spacer(modifier = Modifier.height(10.dp))

                            val password = iTruequeInputPassword(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .focusRequester(focusRequester),
                                label = "Contraseña",
                                keyboardOptions = KeyboardOptions(imeAction = ImeAction.Done),
                            )
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

                        }
                    ) {
                        Text(text = "Inicia sesión")
                    }

                    Text(
                        text = "¿Has olvidado tu contraseña?",
                        modifier = Modifier
                            .align(CenterHorizontally)
                            .padding(8.dp),
                        fontSize = 14.sp,
                        color = Color.Gray
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
                        .align(BottomCenter)
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
                            scope.launch { modalBottomSheetState.animateTo(ModalBottomSheetValue.Expanded) }
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