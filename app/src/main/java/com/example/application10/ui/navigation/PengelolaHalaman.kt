package com.example.application10.ui.navigation


import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
//import com.example.application10.ui.view.DetailView
//import com.example.application10.ui.view.DetailView
import com.example.application10.ui.view.HomeScreen
import com.example.application10.ui.view.InsertMhsView

@Composable
fun PengelolaHalaman(
    modifier: Modifier,
    navController: NavHostController = rememberNavController()
) {
    NavHost(
        navController = navController,
        startDestination = DestinasiHome.route,
        modifier = Modifier
    ) {
        composable(DestinasiHome.route) {
            HomeScreen(
                navigateToItemEntry = {
                    navController.navigate(DestinasiInsert.route)
                },
                onDetailClick = {nim ->
                    navController.navigate("${DestinasiDetail.route}/$nim")
                    println(
                        "PengelolaHalaman: nim = $nim"
                    )
                },
            )
        }
        composable(DestinasiInsert.route) {
            InsertMhsView(
                onBack = { navController.popBackStack() },
                onNavigate = {
                    navController.navigate(DestinasiHome.route)
                }
            )
        }
//        composable(
//            DestinasiDetail.routesWithArg,
//            arguments = listOf(
//                navArgument(DestinasiDetail.NIM) {
//                    type = NavType.StringType
//                }
//            )
//        ) {
//            val nim = it.arguments?.getString(DestinasiDetail.NIM)
//
//            nim?.let { nim ->
//                DetailView(
//                    onBack = {
//                        navController.popBackStack()
//                    },
//                    modifier = modifier,
//                )
//            }
//        }
    }
}