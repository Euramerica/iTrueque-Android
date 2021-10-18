package com.example.itrueque.ui.component.modal

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.itrueque.ui.theme.White

@ExperimentalMaterialApi
@Composable
fun ModalBottomSheet(
    bottomSheetContent: @Composable () -> Unit,
    contentBehind: @Composable () -> Unit,
    sheetState: ModalBottomSheetState = rememberModalBottomSheetState(ModalBottomSheetValue.Hidden)
) {

    ModalBottomSheetLayout(
        sheetState = sheetState,
        sheetShape = MaterialTheme.shapes.small,
        sheetContent = {
            Box(
                modifier = Modifier
                    .background(White)
                    .fillMaxSize()
            ) {
                bottomSheetContent()
            }
        }
    ) {
        contentBehind()
    }
}

@ExperimentalMaterialApi
@Preview
@Composable
fun ModalBottomSheetPreview() {
    ModalBottomSheet(bottomSheetContent = { }, contentBehind = { })
}