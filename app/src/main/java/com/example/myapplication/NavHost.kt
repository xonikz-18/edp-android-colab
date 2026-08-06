package com.example.myapplication

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute

@Composable
fun AppNavHost() {

    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Home
    ) {

        composable<Home> {

            HomeScreen(
                onShowGreeting = { typedName ->
                    navController.navigate(
                        Greeting(userName = typedName)
                    )
                }
            )

        }

        composable<Greeting> { backStackEntry ->

            val greeting: Greeting = backStackEntry.toRoute()

            GreetingScreen(
                userName = greeting.userName,
                onBack = {
                    navController.popBackStack()
                }
            )

        }

    }

}