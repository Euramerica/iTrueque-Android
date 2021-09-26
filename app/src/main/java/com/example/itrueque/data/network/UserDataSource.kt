package com.example.itrueque.data.network

import com.google.firebase.firestore.FirebaseFirestore
import javax.inject.Inject

class UserDataSource
@Inject constructor(
    private val footballPlayerService: FirebaseFirestore
) {

}
