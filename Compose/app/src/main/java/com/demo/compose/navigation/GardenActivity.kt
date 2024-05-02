package com.demo.compose.navigation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import dagger.hilt.android.AndroidEntryPoint
import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.core.app.ShareCompat
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.demo.compose.R

@AndroidEntryPoint
class GardenActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SunflowerApp()
        }
    }
}

data class Plant( val plantId: String, val name: String )

@Composable
fun SunflowerApp() {
    val navController = rememberNavController()
    SunFlowerNavHost(
        navController = navController
    )
}

@Composable
fun SunFlowerNavHost(
    navController: NavHostController
) {
    val activity = (LocalContext.current as Activity)
    NavHost(navController = navController, startDestination = Screen.Home.route) {
        composable(route = Screen.Home.route) {
            HomeScreen(
                onPlantClick = {
                    navController.navigate(
                        Screen.PlantDetail.createRoute(
                            plantId = it.plantId
                        )
                    )
                }
            )
        }
        composable(
            route = Screen.PlantDetail.route,
            arguments = Screen.PlantDetail.navArguments
        ) {
            PlantDetailsScreen(
                onBackClick = { navController.navigateUp() },
                onShareClick = {
                    createShareIntent(activity, it)
                },
                onGalleryClick = {
                    navController.navigate(
                        Screen.Gallery.createRoute(
                            plantName = it.name
                        )
                    )
                }
            )
        }
        composable(
            route = Screen.Gallery.route,
            arguments = Screen.Gallery.navArguments
        ) {
            GalleryScreen(
                onPhotoClick = {
                    val uri = Uri.parse(it)
                    val intent = Intent(Intent.ACTION_VIEW, uri)
                    activity.startActivity(intent)
                },
                onUpClick = {
                    navController.navigateUp()
                })
        }
    }
}

private fun createShareIntent(activity: Activity, plantName: String) {
    Log.d("COMPOSE", "createShareIntent() plantName=$plantName")

    val shareText = activity.getString(R.string.share_text_plant, plantName)
    val shareIntent = ShareCompat.IntentBuilder(activity)
        .setText(shareText)
        .setType("text/plain")
        .createChooserIntent()
        .addFlags(Intent.FLAG_ACTIVITY_NEW_DOCUMENT or Intent.FLAG_ACTIVITY_MULTIPLE_TASK)
    activity.startActivity(shareIntent)
}