package com.catalin.jetpacknavigationtutorial

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.catalin.jetpacknavigationtutorial.model.Hero
import com.catalin.jetpacknavigationtutorial.model.HeroesData
import com.catalin.jetpacknavigationtutorial.ui.theme.JetpackNavigationTutorialTheme

sealed class Destination(val route: String) {
    object Home : Destination("home")
    object Profile : Destination("profile")
    object List : Destination("list")
    object Detail : Destination("detail/{heroId") {
        fun createRoute(heroId: kotlin.collections.List<Hero>) = "detail/$heroId"
    }
}

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackNavigationTutorialTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    val navController = rememberNavController()
                    navigationAppHost(navController = navController)
                }
            }
        }
    }
}

@Composable
fun navigationAppHost(navController: NavHostController) {
    val context = LocalContext.current
    NavHost(navController = navController, startDestination = "home") {
        composable(Destination.Home.route) { HomeScreen(navController) }
        composable(Destination.Profile.route) { ProfileScreen() }
        composable(Destination.List.route) { ListScreen(navController) }
        composable(Destination.Detail.route) {
//            val hero = HeroesData.heroes
//            if (hero == null) {
//                Toast.makeText(context, "Element ID REquires", Toast.LENGTH_SHORT).show()
//            } else {
//                DetailScreen(heroId = HeroesData)
//            }
        }

    }

}
