package com.example.itrueque.ui.view.splash

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.itrueque.Destinations
import com.example.itrueque.R
import com.example.itrueque.ui.component.image.ImageWithInfiniteScaleAnimation
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun SplashScreen(navController: NavController) {
    val viewModel: SplashViewModel = hiltViewModel()

    val needLogin: Boolean by viewModel.needLogin.observeAsState(false)

    viewModel.loadData()
    SplashView()

    LaunchedEffect(rememberCoroutineScope()) {
        delay(4000)
        launch(Dispatchers.Main) {
            if (needLogin) {
                navController.navigate(Destinations.LOGIN_ROUTE)
            } else {
                navController.navigate(Destinations.HOME_ROUTE)
            }
        }
    }
}

@Composable
fun SplashView() {

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colors.primaryVariant)
    ) {

        ImageWithInfiniteScaleAnimation(
            modifier = Modifier
                .align(Alignment.Center)
                .size(300.dp),
            painter = painterResource(R.drawable.itrueque_name_icon)
        )

    }
}

@Preview
@Composable
fun SplashViewPreview() {
    SplashView()
}