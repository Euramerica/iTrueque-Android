package com.example.itrueque.model

import com.google.firebase.firestore.PropertyName

data class User(
    @PropertyName("descripcion")
    val description: String
)
