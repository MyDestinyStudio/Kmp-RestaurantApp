package my.destiny.studio.restaurantapp.screens.orders.presentation.commponment

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import my.destiny.studio.restaurantapp.resources.Res
import my.destiny.studio.restaurantapp.resources.compose_multiplatform
import my.destiny.studio.restaurantapp.resources.tacos
import org.jetbrains.compose.resources.painterResource


@Composable

fun  TabCard(){

     Card(elevation = CardDefaults.cardElevation(defaultElevation = 10.dp), border = BorderStroke(2.dp,
         Color.Red )) {

         Image(painter = painterResource(Res.drawable.compose_multiplatform),contentDescription = null)
         Image(painter = painterResource(Res.drawable.tacos),contentDescription = null)


    }
}