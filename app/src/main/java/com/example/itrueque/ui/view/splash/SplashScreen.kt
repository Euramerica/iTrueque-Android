package com.example.itrueque.ui.view.splash

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.itrueque.R
import com.example.itrueque.ui.component.image.ImageWithInfiniteScaleAnimation
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun SplashScreen(onSplashFinish: () -> Unit) {
    val viewModel: SplashViewModel = hiltViewModel()

    viewModel.loadData()
    SplashView()

    LaunchedEffect(rememberCoroutineScope()) {
        delay(4000)
        launch(Dispatchers.Main) {
            onSplashFinish()
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