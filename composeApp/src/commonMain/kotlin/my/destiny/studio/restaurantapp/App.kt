package my.destiny.studio.restaurantapp


import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import androidx.navigation.compose.rememberNavController
import my.destiny.studio.restaurantapp.core.navigation.Route
import my.destiny.studio.restaurantapp.screens.orders.presentation.OrderScreen
import my.destiny.studio.restaurantapp.screens.orders.presentation.OrderViewModel


@Composable

fun App() {


    val orderViewModel = OrderViewModel()

    val state = orderViewModel.orderState.collectAsStateWithLifecycle()

    MaterialTheme {



        val navController = rememberNavController()


        NavHost(
            navController = navController,
            startDestination = Route.OrderGraph
        ) {

            navigation<Route.OrderGraph>(
                startDestination = Route.OrderDestination
            ) {




               composable<Route.OrderDestination>(
                    exitTransition = { slideOutHorizontally() },
                    popEnterTransition = { slideInHorizontally() }
                ) {

                    OrderScreen(state = state.value, onOrderAction ={

                       orderViewModel.onOrderAction(it)
                    }
                    )

                }
                composable<Route.AdminDestination>(
                   exitTransition = { slideOutHorizontally() },
                   popEnterTransition = { slideInHorizontally() }
               ) {



               }

            }
        }







                }



    }





