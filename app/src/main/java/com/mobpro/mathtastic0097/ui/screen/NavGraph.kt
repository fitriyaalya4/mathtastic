package com.mobpro.mathtastic0097.ui.screen

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument

@Composable
fun NavGraph(navController: NavHostController, modifier: Modifier = Modifier){
    NavHost(navController = navController, startDestination = "home", modifier = modifier) {
        composable("home") { HomeScreen(navController) }
        composable("operation") { OperationScreen(navController) }
        composable("addition") { AdditionScreen(navController) }
        composable("subtraction") { SubtractionScreen(navController) }
        composable("multiplication") { MultiplicationScreen(navController) }
        composable("division") { DivisionScreen(navController) }
        composable("more") { MoreMenuScreen(navController) }

        composable("addition_easy") { AdditionEasyScreen(navController) }
        composable("addition_medium") { AdditionMediumScreen(navController) }
        composable("addition_hard") { AdditionHardScreen(navController) }

        composable("subtraction_easy") { SubtractionEasyScreen(navController) }
        composable("subtraction_medium") { SubtractionMediumScreen(navController) }
        composable("subtraction_hard") { SubtractionHardScreen(navController) }

        composable("multiplication_easy") { MultiplicationEasyScreen(navController) }
        composable("multiplication_medium") { MultiplicationMediumScreen(navController) }
        composable("multiplication_hard") { MultiplicationHardScreen(navController) }

        composable("division_easy") { DivisionEasyScreen(navController) }
        composable("division_medium") { DivisionMediumScreen(navController) }
        composable("division_hard") { DivisionHardScreen(navController) }

        composable(
            route = "score/{quizType}/{trueCount}/{falseCount}/{point}",
            arguments = listOf(
                navArgument("quizType") { type = NavType.StringType },
                navArgument("trueCount") { type = NavType.IntType },
                navArgument("falseCount") { type = NavType.IntType },
                navArgument("point") { type = NavType.IntType }
            )
        ) { backStackEntry ->
            val quizType = backStackEntry.arguments?.getString("quizType") ?: ""
            val trueCount = backStackEntry.arguments?.getInt("trueCount") ?: 0
            val falseCount = backStackEntry.arguments?.getInt("falseCount") ?: 0
            val point = backStackEntry.arguments?.getInt("point") ?: 0

            ScoreScreen(
                navController = navController,
                trueCount = trueCount,
                falseCount = falseCount,
                point = point,
                quizType = quizType
            )
        }

        composable("help") { HelpScreen() }
        composable("about") { AboutScreen() }

        }
    }

