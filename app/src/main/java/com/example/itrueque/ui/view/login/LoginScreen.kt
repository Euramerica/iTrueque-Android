package com.example.itrueque.ui.view.login

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.itrueque.R
import com.example.itrueque.ui.component.button.ITruequeEmailButton
import com.example.itrueque.ui.component.button.ITruequeGoogleButton
import com.example.itrueque.ui.component.button.ITruequeLoginButton
import com.example.itrueque.ui.theme.TurquoiseBlack

@Composable
fun LoginScreen() {
    val viewModel: LoginViewModel = hiltViewModel()

    viewModel.loadData()
    LoginView()
}

@Composable
fun LoginView() {

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
                firstText = "¿Ya tienes una cuenta?",
                secondText = "Inicia Sesión"
            ) {
            }
        }
    }
}

@Preview
@Composable
fun LoginViewPreview() {
    LoginView()
}