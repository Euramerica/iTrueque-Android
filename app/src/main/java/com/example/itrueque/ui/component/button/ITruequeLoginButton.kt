package com.example.itrueque.ui.component.button

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.itrueque.ui.component.text.ITruequeSmallBoldText
import com.example.itrueque.ui.component.text.ITruequeSmallText
import com.example.itrueque.ui.theme.Turquoise
import com.example.itrueque.ui.theme.White

@Composable
fun ITruequeLoginButton(
    modifier: Modifier = Modifier,
    firstText: String,
    secondText: String,
    firstTextColor: Color = White,
    secondTextColor: Color = Turquoise,
    onClick: () -> Unit
) {
    TextButton(
        modifier = modifier,
        contentPadding = PaddingValues(all = 8.dp),
        onClick = {
            onClick()
        },
    ) {
        ITruequeSmallText(
            text = firstText,
            color = firstTextColor
        )

        Spacer(modifier = Modifier.width(5.dp))

        ITruequeSmallBoldText(
            text = secondText,
            color = secondTextColor
        )
    }
}

@Preview
@Composable
fun ITruequeLoginButtonPreview() {
    ITruequeLoginButton(firstText = "fist text", secondText = "second text") {

    }
}