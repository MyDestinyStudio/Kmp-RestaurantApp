package my.destiny.studio.restaurantapp.screens.orders.domain


import my.destiny.studio.restaurantapp.resources.Res
import my.destiny.studio.restaurantapp.resources.chiken
import my.destiny.studio.restaurantapp.resources.fish
import my.destiny.studio.restaurantapp.resources.paccicio
import my.destiny.studio.restaurantapp.resources.pizza
import my.destiny.studio.restaurantapp.resources.salade
import my.destiny.studio.restaurantapp.resources.tacos

import org.jetbrains.compose.resources.DrawableResource


data class FoodCategory(

    val foodName:String,
    val image : DrawableResource

)




val listOfFoodCategory= listOf(

    FoodCategory(  foodName ="Chicken" , image = Res.drawable.chiken  ),
    FoodCategory(  foodName ="Tacos" , image = Res.drawable.tacos  ),
    FoodCategory(  foodName ="Pizza" , image = Res.drawable.pizza ),
    FoodCategory(  foodName ="Paccicio" , image = Res.drawable.paccicio  ),
    FoodCategory(  foodName ="Salade" , image = Res.drawable.salade  ),
    FoodCategory(  foodName ="Poisson" , image = Res.drawable.fish  ),

    )