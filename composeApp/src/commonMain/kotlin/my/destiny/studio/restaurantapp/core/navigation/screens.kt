package my.destiny.studio.restaurantapp.core.navigation

import kotlinx.serialization.Serializable


sealed interface Route {

    @Serializable
    object OrderDestination

    @Serializable
    object AdminDestination

    @Serializable
    object OrderGraph

 
}



