package com.example.composepractice.navigation

import android.util.Log
import androidx.compose.runtime.Composable
import com.example.composepractice.model.UserModel
import com.google.gson.Gson

@Composable
fun ProfileScreen(userData: String) {
    val userData = Gson().fromJson(userData, UserModel::class.java)

    Log.d("TAG", "ProfileScreen: ${userData}")
}