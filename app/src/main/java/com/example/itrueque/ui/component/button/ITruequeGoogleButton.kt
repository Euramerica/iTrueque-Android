package com.example.itrueque.ui.component.button

import android.util.Log
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.itrueque.R
import com.example.itrueque.ui.component.text.ITruequeSmallText
import com.example.itrueque.ui.theme.Shapes
import com.example.itrueque.ui.theme.TurquoiseBlack
import com.example.itrueque.ui.theme.White

@Composable
fun ITruequeGoogleButton(
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {
    Button(
        modifier = modifier
            .fillMaxWidth()
            .height(48.dp),
        elevation = ButtonDefaults.elevation(defaultElevation = 0.dp),
        contentPadding = PaddingValues(all = 8.dp),
        shape = Shapes.medium,
        colors = ButtonDefaults.textButtonColors(
            backgroundColor = White,
            contentColor = TurquoiseBlack
        ),
        onClick = {
            onClick()
        },
    ) {
        Box(modifier = Modifier.fillMaxWidth()) {
            Icon(
                painter = painterResource(id = R.drawable.g_logo),
                contentDescription = "Google icon",
                Modifier
                    .align(
                        Alignment.CenterStart
                    )
                    .size(16.dp)
            )
            ITruequeSmallText(
                text = "Continuar con Google",
                modifier = Modifier.align(
                    Alignment.Center
                )
            )
        }

    }
}

@Preview
@Composable
fun ITruequeGoogleButtonPreview() {
    ITruequeGoogleButton(
        onClick = {
            Log.d("ButtonClick", "¡Click!")
        }
    )
}