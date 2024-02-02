package com.example.composepractice.navigation

sealed class Screen(val route: String) {

    object MainScreen : Screen("main_screen")
    object DetailScreen : Screen("detail_screen")
    object ProfileScreen : Screen("profile_screen")

    fun detailScreenArgs (name: String, age: Int, isParentAllowed: Boolean): String {
        return buildString {
            append("$route/$name/$age/$isParentAllowed")
        }
    }

    fun profileScreenArgs(userData: String): String {
        return buildString {
            append("$route/$userData")
        }
    }
}
