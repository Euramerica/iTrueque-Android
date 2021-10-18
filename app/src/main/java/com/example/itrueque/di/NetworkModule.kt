package com.example.itrueque.di

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.CollectionReference
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {

    @Provides
    fun provideFireStore(): FirebaseFirestore {
        return Firebase.firestore
    }

    @Provides
    fun provideUserCollection(
        fireStore: FirebaseFirestore
    ): CollectionReference {
        return fireStore.collection("usuarios")
    }

    @Provides
    fun provideFirebaseAuth(
    ): FirebaseAuth {
        return Firebase.auth
    }
}
