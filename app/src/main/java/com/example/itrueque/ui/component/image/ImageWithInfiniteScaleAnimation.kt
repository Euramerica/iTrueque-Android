package com.example.itrueque.ui.component.image

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.itrueque.R
import com.example.itrueque.ui.animation.infiniteScaleAnimation

@Composable
fun ImageWithInfiniteScaleAnimation(
    modifier: Modifier = Modifier,
    painter: Painter,
    initialValue: Float = 1F,
    targetValue: Float = 1.2F
) {
    Box(
        modifier = modifier.scale(
            infiniteScaleAnimation(
                duration = 1000,
                initialValue = initialValue,
                targetValue = targetValue
            )
        )
    ) {
        Image(
            painter = painter,
            contentDescription = "App name icon",
            modifier = Modifier
                .align(Alignment.Center)
                .size(300.dp)
        )
    }
}

@Preview
@Composable
fun ImageWithInfiniteScaleAnimationPreview() {
    ImageWithInfiniteScaleAnimation(
        painter = painterResource(R.drawable.itrueque_name_icon)
    )
}
