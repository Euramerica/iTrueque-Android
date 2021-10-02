package com.example.itrueque.ui.component.text

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.itrueque.R
import com.example.itrueque.ui.theme.TurquoiseBlack

@Composable
fun ITruequeSmallBoldText(
    modifier: Modifier = Modifier,
    text: String,
    color: Color = TurquoiseBlack
) {
    Text(
        text = text,
        modifier = modifier,
        fontSize = 16.sp,
        fontWeight = FontWeight.Bold,
        color = color,
    )
}

@Preview
@Composable
fun ITruequeSmallTextBoldPreview() {
    ITruequeSmallBoldText(text = stringResource(id = R.string.app_name))
}
