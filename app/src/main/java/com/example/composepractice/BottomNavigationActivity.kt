package com.example.composepractice

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.composepractice.model.BottomNavItem

class BottomNavigationActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()

            Scaffold(bottomBar = {
                BottomNavigationBar(
                    item = listOf(
                        BottomNavItem(
                            name = "Home",
                            route = BottomNavScreens.HomeScreen.route,
                            icon = Icons.Default.Home
                        ), BottomNavItem(
                            name = "Notifications",
                            route = BottomNavScreens.NotificationScreen.route,
                            icon = Icons.Default.Notifications,
                            badgeCount = 40
                        ), BottomNavItem(
                            name = "Settings",
                            route = BottomNavScreens.SettingsScreen.route,
                            icon = Icons.Default.Settings
                        )
                    ),
                    navController = navController,
                    onItemClick = {
                        navController.navigate(it.route)
                    }
                )
            }) {
                BottomNavNavigation(navController = navController, it.calculateBottomPadding())
            }
        }
    }
}

@Composable
fun BottomNavNavigation(navController: NavHostController, bottomPadding: Dp) {
    NavHost(navController = navController, startDestination = BottomNavScreens.HomeScreen.route) {
        composable(route = BottomNavScreens.HomeScreen.route) {
            HomeScreen(bottomPadding)
        }

        composable(route = BottomNavScreens.NotificationScreen.route) {
            NotificationScreen(bottomPadding)
        }

        composable(route = BottomNavScreens.SettingsScreen.route) {
            SettingsScreen(bottomPadding)
        }
    }
}

sealed class BottomNavScreens(val route: String) {
    object HomeScreen : BottomNavScreens("home_screen")
    object NotificationScreen : BottomNavScreens("notification_screen")
    object SettingsScreen : BottomNavScreens("settings_screen")
}

@Composable
fun HomeScreen(bottomPadding: Dp) {
    Box(
        modifier = Modifier
            .padding(bottom = bottomPadding)
            .fillMaxSize(), contentAlignment = Alignment.Center
    ) {
        Text(text = "Home Screen")
    }
}

@Composable
fun NotificationScreen(bottomPadding: Dp) {
    Box(
        modifier = Modifier
            .padding(bottom = bottomPadding)
            .fillMaxSize(), contentAlignment = Alignment.Center
    ) {
        Text(text = "Notification Screen")
    }
}

@Composable
fun SettingsScreen(bottomPadding: Dp) {
    Box(
        modifier = Modifier
            .padding(bottom = bottomPadding)
            .fillMaxSize(), contentAlignment = Alignment.Center
    ) {
        Text(text = "Settings Screen")
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BottomNavigationBar(
    item: List<BottomNavItem>,
    navController: NavController,
    modifier: Modifier = Modifier,
    onItemClick: (BottomNavItem) -> Unit
) {
    val backStackEntry = navController.currentBackStackEntryAsState()
    BottomAppBar(
        modifier = modifier
            .fillMaxWidth()
            .fillMaxSize(0.1f)
            .clip(shape = RoundedCornerShape(topStart = 20.dp, topEnd = 20.dp)),
        containerColor = Color.DarkGray,
        tonalElevation = 5.dp
    ) {
        item.forEach { item ->
            val selected = item.route == backStackEntry.value?.destination?.route
            NavigationBarItem(selected = selected,
                onClick = { onItemClick(item) },
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = Color.Green,
                    selectedTextColor = Color.Green,
                    unselectedIconColor = Color.Gray,
                    unselectedTextColor = Color.Gray,
                    indicatorColor = Color.DarkGray
                ),
                icon = {
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        if (item.badgeCount > 0) {
                            BadgedBox(badge = {
                                Badge (containerColor = Color.Red, contentColor = Color.Green) {
                                    Text(text = item.badgeCount.toString())
                                }
                            }) {
                                Icon(
                                    imageVector = item.icon,
                                    contentDescription = "gjhj",
                                    modifier = Modifier.size(30.dp)
                                )
                            }
                        } else {
                            Icon(
                                imageVector = item.icon,
                                contentDescription = item.name,
                                modifier = Modifier.size(30.dp)
                            )
                        }
                        Text(
                            text = item.name, textAlign = TextAlign.Center, fontSize = 10.sp
                        )
                    }
                })
        }
    }
}