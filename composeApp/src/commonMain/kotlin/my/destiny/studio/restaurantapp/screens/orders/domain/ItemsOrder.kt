package my.destiny.studio.restaurantapp.screens.orders.domain

import my.destiny.studio.restaurantapp.resources.Res
import my.destiny.studio.restaurantapp.resources.broiled_fish
import my.destiny.studio.restaurantapp.resources.chiken
import my.destiny.studio.restaurantapp.resources.crab
import my.destiny.studio.restaurantapp.resources.crevettes
import my.destiny.studio.restaurantapp.resources.paccicio
import my.destiny.studio.restaurantapp.resources.pizza
import my.destiny.studio.restaurantapp.resources.saladechourouge
import my.destiny.studio.restaurantapp.resources.salademaroccain
import my.destiny.studio.restaurantapp.resources.saladeparisienne
import my.destiny.studio.restaurantapp.resources.saladeroyal
import my.destiny.studio.restaurantapp.resources.salamon
import my.destiny.studio.restaurantapp.resources.saldefruite
import my.destiny.studio.restaurantapp.resources.shark
import my.destiny.studio.restaurantapp.resources.tacos
import org.jetbrains.compose.resources.DrawableResource

data class ItemsOrder(
    val foodName :String,
    val category:  String,
    val price : Double,
    var quantity : Int=1,
    val image: DrawableResource,
    val description :String?
)


val listOfItemsOrder= listOf(
    ItemsOrder(

        foodName ="Tacos ViandeHache",
        category="Tacos",
        price =20.00,
        quantity=1,
        image= Res.drawable.tacos,
        description ="Sans fries",


        ),
    ItemsOrder(

        foodName ="Tacos Mixte",
        category="Tacos",
        price =30.00,
        quantity=1,
        image= Res.drawable.tacos,
        description ="With fries",


        ),
    ItemsOrder(

        foodName ="Tacos Nuggets",
        category="Tacos",
        price =37.00,
        quantity=1,
        image= Res.drawable.tacos,
        description ="With fries",


        ),
    ItemsOrder(

        foodName ="Tacos Special ",
        category="Tacos",
        price =40.00,
        quantity=1,
        image= Res.drawable.tacos,
        description ="With fries + coke",


        ),
    ItemsOrder(

        foodName ="Chicken  Special ",
        category="Chicken",
        price = 140.00,
        quantity=1,
        image= Res.drawable.chiken,
        description ="With fries + coke",


        ),
            ItemsOrder(

            foodName ="1/2 Chicken  Special ",
    category="Chicken",
    price = 70.00,
    quantity=1,
    image= Res.drawable.chiken,
    description ="With coke",


    ),
    ItemsOrder(

        foodName ="Paccicio Dinde ",
        category="Paccicio",
        price = 40.00,
        quantity=1,
        image= Res.drawable.paccicio,
        description ="With fries + coke",


        ),
            ItemsOrder(

            foodName ="Paccicio Mixte ",
    category="Paccicio",
    price = 70.00,
    quantity=1,
    image= Res.drawable.paccicio,
    description ="With fries  ",


    ),
    ItemsOrder(

        foodName ="Paccicio Special",
        category="Paccicio",
        price = 80.00,
        quantity=1,
        image= Res.drawable.paccicio,
        description ="With fries + coke ",


        ),
    ItemsOrder(

        foodName ="Paccicio 4 Secion",
        category="Pizza",
        price = 40.00,
        quantity=1,
        image= Res.drawable.pizza,
        description ="With fries + coke ",


        ),
    ItemsOrder(

        foodName ="Paccicio Margarita",
        category="Pizza",
        price = 27.00,
        quantity=1,
        image= Res.drawable.pizza,
        description ="With fries + coke ",


        ),
    ItemsOrder(

        foodName ="Paccicio Italian",
        category="Pizza",
        price = 80.00,
        quantity=1,
        image= Res.drawable.pizza,
        description ="With fries + coke ",


        ),
    ItemsOrder(

        foodName ="Paccicio Special",
        category="Pizza",
        price = 20.00,
        quantity=1,
        image= Res.drawable.paccicio,
        description ="With fries + coke ",


        ),
    ItemsOrder(

        foodName ="Shark",
        category="Poisson",
        price = 80.00,
        quantity=1,
        image= Res.drawable.shark,
        description ="With fries + coke ",


        ),
    ItemsOrder(

      foodName ="Broiled  Fish",
        category="Poisson",
        price = 240.00,
        quantity=1,
        image= Res.drawable.broiled_fish,
        description ="With fries + coke + salade ",


        ),
    ItemsOrder(

        foodName ="Crab",
        category="Poisson",
        price = 300.00,
        quantity=1,
        image= Res.drawable.crab,
        description ="With fries + coke + salade",


        ),
    ItemsOrder(

        foodName ="Crevettes",
        category="Poisson",
        price = 170.00,
        quantity=1,
        image= Res.drawable.crevettes,
        description ="With fries + coke + salade",


        ),
    ItemsOrder(

        foodName ="Salamon",
        category="Poisson",
        price = 170.00,
        quantity=1,
        image= Res.drawable.salamon,
        description ="With fries + coke + salade",


        ),
    ItemsOrder(

        foodName ="Salade Chou Rouge",
        category="Salade",
        price = 170.00,
        quantity=1,
        image= Res.drawable.saladechourouge,
        description =" ",


        ),
    ItemsOrder(

        foodName ="Salade Marocain",
        category="Salade",
        price = 20.00,
        quantity=1,
        image= Res.drawable.salademaroccain,
        description ="With fries + coke + salade",


        ),
    ItemsOrder(

        foodName ="Salade Parisienne",
        category="Salade",
        price = 90.00,
        quantity=1,
        image= Res.drawable.saladeparisienne,
        description ="With fries + coke + salade",


        ),
    ItemsOrder(

        foodName ="Salade Royal",
        category="Salade",
        price = 30.00,
        quantity=1,
        image= Res.drawable.saladeroyal,
        description ="With fries + coke + salade",


        ),
    ItemsOrder(

        foodName ="Salade Fruite",
        category="Salade",
        price = 100.00,
        quantity=1,
        image= Res.drawable.saldefruite,
        description ="With fries + coke + salade",


        ),


)