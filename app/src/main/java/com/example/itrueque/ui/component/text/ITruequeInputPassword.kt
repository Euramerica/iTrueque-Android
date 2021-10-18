package com.example.itrueque.ui.component.text

import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.runtime.*
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview

@ExperimentalComposeUiApi
@Composable
fun iTruequeInputPassword(
    modifier: Modifier = Modifier,
    label: String,
    keyboardOptions: KeyboardOptions = KeyboardOptions(imeAction = ImeAction.Next),
    focusRequester: FocusRequester = FocusRequester.createRefs().component1(),
): String {

    var text by remember { mutableStateOf("") }
    var passwordVisibility: Boolean by remember { mutableStateOf(false) }
    val keyboardController = LocalSoftwareKeyboardController.current

    OutlinedTextField(
        modifier = modifier,
        value = text,
        keyboardOptions = keyboardOptions,
        keyboardActions = KeyboardActions(
            onNext = { focusRequester.requestFocus() },
            onDone = { keyboardController?.hide() }
        ),
        onValueChange = { text = it },
        label = { Text(label) },
        visualTransformation = if (passwordVisibility) VisualTransformation.None else PasswordVisualTransformation(),
        trailingIcon = {
            val image = if (passwordVisibility)
                Icons.Filled.Visibility
            else Icons.Filled.VisibilityOff
            IconButton(onClick = {
                passwordVisibility = !passwordVisibility
            }) {
                Icon(imageVector = image, contentDescription = "visibility image")
            }
        }
    )

    return text
}

@ExperimentalComposeUiApi
@Preview
@Composable
fun ITruequeInputPasswordPreview() {
    iTruequeInput(label = "label")
}