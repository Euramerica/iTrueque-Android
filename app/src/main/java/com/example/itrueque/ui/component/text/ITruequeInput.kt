package com.example.itrueque.ui.component.text

import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview

@ExperimentalComposeUiApi
@Composable
fun iTruequeInput(
    modifier: Modifier = Modifier,
    label: String,
    keyboardOptions: KeyboardOptions = KeyboardOptions(imeAction = ImeAction.Next),
    focusRequester: FocusRequester = FocusRequester.createRefs().component1(),
): String {

    var text by remember { mutableStateOf("") }
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
        label = { Text(label) }
    )

    return text
}

@ExperimentalComposeUiApi
@Preview
@Composable
fun ITruequeInputPreview() {
    iTruequeInput(label = "label")
}