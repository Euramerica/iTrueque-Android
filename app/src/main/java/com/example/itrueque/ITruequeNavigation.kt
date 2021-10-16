package com.example.itrueque

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.itrueque.ui.transition.TransitionAlphaFadeInFadeOut
import com.example.itrueque.ui.view.login.LoginScreen
import com.example.itrueque.ui.view.splash.SplashScreen

object Destinations {
    const val LOGIN_ROUTE = "login"
    const val SPLASH_ROUTE = "splash"
}

@ExperimentalComposeUiApi
@ExperimentalMaterialApi
@ExperimentalAnimationApi
@Composable
fun ITruequeNavigation(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    startDestination: String = Destinations.SPLASH_ROUTE,
) {
    NavHost(
        navController = navController,
        startDestination = startDestination,
        modifier = modifier
    ) {

        composable(Destinations.LOGIN_ROUTE) {
            TransitionAlphaFadeInFadeOut {
                LoginScreen()
            }
        }

        composable(Destinations.SPLASH_ROUTE) {
            TransitionAlphaFadeInFadeOut {
                SplashScreen(navController)
            }
        }
    }
}
