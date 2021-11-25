package com.example.itrueque.ui.component.button

import android.util.Log
import androidx.appcompat.app.AlertDialog
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout. height
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.itrueque.ui.component.text.ITruequeSmallText
import com.example.itrueque.ui.theme.Shapes
import com.example.itrueque.ui.theme.White
import com.google.firebase.auth.FirebaseAuth
import java.security.Provider

enum class ProviderType {
    BASIC
}

@Composable
fun ITruequeCreateAccountButton(
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
        colors = ButtonDefaults.textButtonColors(
            backgroundColor = MaterialTheme.colors.secondary,
            contentColor = White
        ),
        onClick = {
            onClick()
        },
    ) {
        Box(modifier = Modifier.fillMaxWidth()) {

            ITruequeSmallText(
                text = "Crear cuenta",
                modifier = Modifier.align(
                    Alignment.Center
                ),
                color = White
            )
        }

    }
/*
    if(.text.isNotEmpty() && .text.isNotEmpty() ){
        FirebaseAuth.getInstance()
            .createUserWithEmailAndPassword().addOnCompleteListener {
                if(it.isSuccessful){
                    //TODO showHome(it.result?.user?.email ?: "", ProviderType.BASIC)
                }else{
                    showAlert()
                }
            }
    }*/


}
/*
    private fun showAlert() {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Error")
        builder.setMessage("Se ha producido un error autenticando al usuario")
        builder.setPositiveButton("Aceptar",null)
        val dialog: AlertDialog = builder.create()
        dialog.show()
    }*/

    private fun showHome(email:String, provider: ProviderType){
    //TODO: HOME putExtra(email, provider
    }


@Preview
@Composable
fun ITruequeCreateAccountButtonPreview() {
    ITruequeCreateAccountButton(
        onClick = {
            Log.d("ButtonClick", "¡Click!")
        }
    )
}