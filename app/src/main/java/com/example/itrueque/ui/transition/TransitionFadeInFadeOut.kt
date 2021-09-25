package com.example.itrueque.ui.transition

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.MutableTransitionState
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember

@ExperimentalAnimationApi
@Composable
fun TransitionAlphaFadeInFadeOut(
    enterDuration: Int = 250,
    exitDuration: Int = 100,
    content: @Composable () -> Unit,
) {
    AnimatedVisibility(
        visibleState = remember { MutableTransitionState(false) }
            .apply { targetState = true },
        enter = fadeIn(
            initialAlpha = 0f,
            tween(durationMillis = enterDuration)
        ),
        exit = fadeOut(
            targetAlpha = 0f,
            tween(durationMillis = exitDuration)
        ),
    ) {
        content()
    }
}
