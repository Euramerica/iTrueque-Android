package com.example.itrueque.ui.view.register

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Email
import androidx.compose.runtime.*
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.Paragraph
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withStyle

import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.itrueque.Destinations
import com.example.itrueque.R
import com.example.itrueque.ui.component.button.*
import com.example.itrueque.ui.theme.GrayLight
import com.example.itrueque.ui.view.login.LoginViewModel


@ExperimentalComposeUiApi
@ExperimentalMaterialApi
@Composable
fun RegisterScreen(navController: NavController)  {
    val viewModel: RegisterViewModel = hiltViewModel()

    when (val event = viewModel.event.collectAsState().value) {
        is RegisterViewModel.UIEvent.Loading -> {
        }
        is RegisterViewModel.UIEvent.ErrorRegister -> {
            Toast.makeText(
                LocalContext.current,
                when (event.error) {
                    RegisterViewModel.RegisterError.EMPTY_FIELD_ERROR -> "Los campos están vacios"
                },
                Toast.LENGTH_SHORT
            ).show()
        }
    }

    viewModel.loadData()
    RegisterView()
}

@Composable
fun RegisterView() {
    Text(text = "Text Inputs",  modifier = Modifier.padding(8.dp))
    var text by remember { mutableStateOf(TextFieldValue("")) }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(GrayLight)
    ) {

        Spacer(modifier = Modifier.height(10.dp))

        Column () {
            Text("Únete a iTrueque",
                color = Color(0xFF2C3A40),
                fontSize = 55.sp,
                //fontStyle = FontStyle.Italic,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .padding(12.dp)
                    .fillMaxWidth(),
            )

            Spacer(modifier = Modifier.height(50.dp))

            TextField(
                value = text,
                onValueChange = { newValue -> text = newValue },
                modifier = Modifier
                    .padding(8.dp)
                    .fillMaxWidth(),
                label = { Text("Nombre y Apellidos", color = Color.Gray) },
                placeholder = { Text("placeholder") },
            )

             OutlinedTextField(
                value = text,
                leadingIcon = { Icon(imageVector = Icons.Default.Email, contentDescription = null) },
                modifier = Modifier
                    .padding(8.dp)
                    .fillMaxWidth(),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
                label = { Text(text = "Email", color = Color.DarkGray) },
                placeholder = { Text(text = "Email", color = Color.DarkGray) },
                onValueChange = {
                    text = it
                }
            )

            OutlinedTextField(
                value = text,
                modifier = Modifier
                    .padding(8.dp)
                    .fillMaxWidth(),
                label = { Text(text = "Contraseña") },
                placeholder = { Text(text = "12334444") },
                visualTransformation = PasswordVisualTransformation(),
                onValueChange = {
                    text = it
                },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)
            )
        }

        /*
        OutlinedTextField(
            value = text,
            modifier = Modifier
                .padding(8.dp)
                .fillMaxWidth(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
            label = { Text(text = "Confirma tu contraseña", color = Color.DarkGray)  },
            placeholder = { Text(text = "Confirma tu contraseña", color = Color.DarkGray) },
            onValueChange = {
                text = it
            }
        )*/

        Column(
            modifier = Modifier
                .padding(start = 16.dp, end = 16.dp, bottom = 40.dp)
                .align(Alignment.BottomCenter)
        ) {
            ITruequeCreateAccountButton {

            }
        }
    }
}

@Preview
@Composable
fun RegisterViewPreview() {
    RegisterView()
}