package com.example.itrueque.ui.view.login

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.itrueque.R

@Composable
fun LoginScreen() {
    val viewModel: LoginViewModel = hiltViewModel()

    viewModel.loadData()
    LoginView()
}

@Composable
fun LoginView() {
    Text(text = "Login")
}

@Preview
@Composable
fun LoginViewPreview() {
    LoginView()
}