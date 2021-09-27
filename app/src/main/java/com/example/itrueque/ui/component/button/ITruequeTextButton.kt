package com.example.itrueque.ui.component.button

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.itrueque.R
import com.example.itrueque.ui.component.text.ITruequeSmallBoldText
import com.example.itrueque.ui.component.text.ITruequeSmallText
import com.example.itrueque.ui.theme.TurquoiseBlack

@Composable
fun ITruequeTextButton(
    modifier: Modifier = Modifier,
    text: String,
    textColor: Color = TurquoiseBlack,
    isBoldText: Boolean = false,
    onClick: () -> Unit
) {
    TextButton(
        modifier = modifier,
        contentPadding = PaddingValues(all = 8.dp),
        onClick = {
            onClick()
        },
    ) {
        if (isBoldText) ITruequeSmallText(
            text = text,
            color = textColor
        ) else ITruequeSmallBoldText(text = text, color = textColor)
    }
}

@Preview
@Composable
fun ITruequeTextButtonBoldPreview() {
    ITruequeTextButton(text = stringResource(id = R.string.app_name), isBoldText = true) {

    }
}

@Preview
@Composable
fun ITruequeTextButtonPreview() {
    ITruequeTextButton(text = stringResource(id = R.string.app_name), isBoldText = false) {

    }
}