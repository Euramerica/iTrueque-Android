package com.example.itrueque.data.network

import com.google.firebase.firestore.CollectionReference
import javax.inject.Inject

class UserDataSource
@Inject constructor(
    private val userCollection: CollectionReference
) {

}
