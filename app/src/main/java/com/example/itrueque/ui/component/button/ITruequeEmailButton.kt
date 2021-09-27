package com.example.itrueque.ui.component.button

import android.util.Log
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Email
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.itrueque.ui.component.text.ITruequeSmallText
import com.example.itrueque.ui.theme.Shapes
import com.example.itrueque.ui.theme.Turquoise
import com.example.itrueque.ui.theme.White

@Composable
fun ITruequeEmailButton(
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
        border = BorderStroke(1.dp, Turquoise),
        colors = ButtonDefaults.textButtonColors(
            backgroundColor = White,
            contentColor = Turquoise
        ),
        onClick = {
            onClick()
        },
    ) {
        Box(modifier = Modifier.fillMaxWidth()) {
            Icon(
                imageVector = Icons.Outlined.Email,
                contentDescription = "Google icon",
                Modifier.align(
                    Alignment.CenterStart
                )
            )
            ITruequeSmallText(
                text = "Continuar con email",
                modifier = Modifier.align(
                    Alignment.Center
                )
            )
        }

    }
}

@Preview
@Composable
fun ITruequeEmailButtonPreview() {
    ITruequeEmailButton(
        onClick = {
            Log.d("ButtonClick", "¡Click!")
        }
    )
}