package com.example.composepractice.navigation

import android.util.Log
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.composepractice.model.UserModel
import com.google.gson.Gson

@Composable
fun DetailScreen(navController: NavController, name: String?, age: Int?, isParentAllowed: Boolean) {
    Box(
        contentAlignment = Alignment.Center, modifier = Modifier.fillMaxSize()
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {

            name?.let { name ->
                Text(text = name)
            }
            age?.let { age ->
                Text(text = age.toString())
            }

            Text(text = isParentAllowed.toString())

            Button(onClick = {
                val data = Gson().toJson(UserModel("Abdullah", 29, false, 5.8f))
                navController.navigate(Screen.ProfileScreen.profileScreenArgs(data))
            }) {
                Text(text = "Profile Screen")
            }
        }
    }
}