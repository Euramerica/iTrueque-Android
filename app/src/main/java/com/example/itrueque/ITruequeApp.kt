package com.example.itrueque

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.example.itrueque.ui.theme.ITruequeTheme

@ExperimentalAnimationApi
@Composable
fun ITruequeApp() {
    ITruequeTheme {
        Scaffold { innerPaddingModifier ->
            ITruequeNavigation(modifier = Modifier.padding(innerPaddingModifier))
        }
    }
}
