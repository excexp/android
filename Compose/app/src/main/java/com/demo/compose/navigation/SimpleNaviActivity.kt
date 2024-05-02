package com.demo.compose.navigation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

class NavigationActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            MyApp()
        }
    }
}

@Composable
fun Profile(onNavigateToFriendList: () -> Unit) {
    Column(
        Modifier
            .background(Color.LightGray)
            .fillMaxSize()) {
        Text("Profile")

        Button(onClick = { onNavigateToFriendList() }) {
            Text("Go to FriendList")
        }
    }
}

@Composable
fun FriendList(onNavigateToProfile: () -> Unit) {
    Column(
        Modifier
            .background(Color.Gray)
            .fillMaxSize()) {
        Text("FriendList")

        Button(onClick = { onNavigateToProfile() }) {
            Text("Go to Profile")
        }
    }
}

@Composable
fun FriendDetail(onNavigateToProfile: () -> Unit) {
    Column(
        Modifier
            .background(Color.Gray)
            .fillMaxSize()) {
        Text("Friend Detail")

        Button(onClick = { onNavigateToProfile() }) {
            Text("Go to Profile")
        }
    }
}

@Preview
@Composable
fun MyApp() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "profile") {
        composable("profile") {
            Profile(onNavigateToFriendList = {
                navController.navigate("friendList")
            })
        }

        composable("friendList") {
            FriendList(onNavigateToProfile = {
                navController.navigate("profile")
            })
        }
    }
}