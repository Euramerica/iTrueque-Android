package com.example.itrueque.ui.view.home

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController

@Composable
fun HomeScreen(navController: NavController) {
    val viewModel: HomeViewModel = hiltViewModel()
    HomeView()
}

@Composable
fun HomeView() {

    Text(text = "Home")

}