package com.example.composepractice.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument

@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screen.MainScreen.route) {
        composable(route = Screen.MainScreen.route) {
            MainScreen(navController = navController)
        }
        composable(
            route = "${Screen.DetailScreen.route}/{name}/{age}/{isParentAllowed}",
            arguments = listOf(
                navArgument("name") {
                    type = NavType.StringType
                    nullable = true
                },
                navArgument("age") {
                    type = NavType.IntType
                    nullable = false
                },
                navArgument("isParentAllowed") {
                    type = NavType.BoolType
                    nullable = false
                }
            )
        ) { navBackStackEntry ->
            DetailScreen(
                navController = navController,
                name = navBackStackEntry.arguments?.getString("name"),
                age = navBackStackEntry.arguments?.getInt("age"),
                isParentAllowed = navBackStackEntry.arguments!!.getBoolean("isParentAllowed")
            )
        }
        composable(
            route = "${Screen.ProfileScreen.route}/{userData}",
            arguments = listOf(
                navArgument("userData") {
                    type = NavType.StringType
                    nullable = false
                })
        ) { navBackStackEntry ->
            ProfileScreen(userData = navBackStackEntry.arguments?.getString("userData")!!)
        }
    }
}