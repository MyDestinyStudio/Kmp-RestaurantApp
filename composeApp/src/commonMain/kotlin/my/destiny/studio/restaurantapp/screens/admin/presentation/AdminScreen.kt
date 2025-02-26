package my.destiny.studio.restaurantapp.screens.admin.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Add
import androidx.compose.material.icons.rounded.Close
import androidx.compose.material.icons.rounded.Remove

import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import my.destiny.studio.restaurantapp.core.presentation.AppColor
import my.destiny.studio.restaurantapp.resources.Res
import my.destiny.studio.restaurantapp.resources.tacos
import my.destiny.studio.restaurantapp.screens.orders.domain.ItemsOrder
import org.jetbrains.compose.resources.painterResource

//
//@Composable
//fun AdminScreen() {
//
//
//
//
//}

@Composable
fun ItemsOrderCard(

    itemsOrder: ItemsOrder =  ItemsOrder(
                                  foodName ="Tacos Dinde",
                                  category="Tacos",
                                  price =20.00,
                                  image= Res.drawable.tacos,
                                  description ="With fries",
                                      )
    ,
    itemClicked: (ItemsOrder)->Unit ={},

    nameSize:Int=25,
    descriptionSize:Int=12,


) {


    Card( modifier = Modifier.clickable { itemClicked(itemsOrder) },
        colors = CardDefaults.cardColors(containerColor = AppColor.SandYellow),
        elevation = CardDefaults.cardElevation(defaultElevation = 7.dp, pressedElevation = 18.dp)
        ) {

       Card( modifier = Modifier.padding(10.dp).clickable {itemClicked(itemsOrder)},
           elevation = CardDefaults.cardElevation(defaultElevation = 4.dp )){
            Image(
                painter = painterResource(itemsOrder.image),
                modifier = Modifier.aspectRatio(1f).size(70.dp) ,
                contentScale = ContentScale.FillBounds,
                contentDescription = "Image Item"
            )
        }

        Row (modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically){
            Text(
                modifier = Modifier.weight(1f ),
                text = itemsOrder.foodName,
                fontSize = nameSize.sp,
                style = TextStyle(textAlign = TextAlign.Start),
                maxLines = 1,
                color = AppColor.DesertWhite,


                )

            Text(
                modifier = Modifier.weight(1f ).padding(horizontal = 3.dp),
                text = "${itemsOrder.price} Dhs" ,
                fontSize = nameSize.sp,
                style = TextStyle(textAlign = TextAlign.End),
                maxLines = 1,
                color = AppColor.DesertWhite,


                )
        }
        Text(modifier = Modifier.align(Alignment.CenterHorizontally).padding(bottom = 7.dp),
            text = itemsOrder.description ?: "",
            fontSize = descriptionSize.sp,
            style = TextStyle(textAlign = TextAlign.Center   ),
            maxLines = 1,
            color = AppColor.DesertWhite ,


            )

    }




}

@Composable
fun ItemsOrderCartCard(

    itemsOrder: ItemsOrder=ItemsOrder(

        foodName ="Tacos Dinde",
        category="Tacos",
        price =20.00,
        image= Res.drawable.tacos,
        description ="With fries",

        )
    ,
  // imageSize:Int=25,
    nameSize:Int=25,
    descriptionSize:Int=12,
    itemRemove: ( )->Unit ={}
) {


    val iconSize = 30.dp


    var count      by rememberSaveable  { mutableIntStateOf(1)   }



    Box {



        Card(
            modifier = Modifier.fillMaxWidth().padding( iconSize/2 ).height(IntrinsicSize.Min),
            colors = CardDefaults.cardColors(containerColor = AppColor.SandYellow),
            elevation = CardDefaults.cardElevation(
                defaultElevation = 18.dp,
                pressedElevation = 30.dp
            )
        ) {


            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {

                Card(
                    modifier = Modifier.padding(10.dp).weight(0.3f),
                    elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
                ) {
                    Image(
                        painter = painterResource(itemsOrder.image),
                        modifier = Modifier.fillMaxSize().aspectRatio(1f),
                        contentScale = ContentScale.FillBounds,
                        contentDescription = "Image Item"
                    )
                }

                Column(modifier = Modifier.weight(0.5f)) {
                    Text(
                        modifier = Modifier,
                        text = itemsOrder.foodName,
                        fontSize = nameSize.sp,
                        style = TextStyle(textAlign = TextAlign.Start),
                        maxLines = 1,
                        color = AppColor.DesertWhite,
                    )

                    Card(

                        modifier = Modifier.padding(10.dp).align(Alignment.CenterHorizontally),
                        colors = CardDefaults.cardColors(containerColor = AppColor.SandYellow),
                        elevation = CardDefaults.cardElevation(defaultElevation = 3.dp)

                    ) {
                        Row(verticalAlignment = Alignment.CenterVertically) {

                            IconButton(

                                onClick = {
                                    if (count > 1) {
                                        count--
                                     //   itemOrderQuantity(itemsOrder.copy(quantity = count))
                                    }
                                }

                            ) {
                                Icon(
                                    imageVector = Icons.Rounded.Remove,
                                    contentDescription = null,
                                    tint = AppColor.DesertWhite
                                )
                            }

                            Text(text = "$count", maxLines = 1, color = AppColor.DesertWhite)


                            IconButton(
                                onClick = {
                                    count++
                                   // itemOrderQuantity(itemsOrder.copy(quantity = count))
                                }
                            ) {
                                Icon(
                                    imageVector = Icons.Rounded.Add,
                                    contentDescription = null,
                                    tint = AppColor.DesertWhite
                                )
                            }

                        }
                    }
                }

                Text(
                    modifier = Modifier.padding(end = 3.dp).weight(0.2f),
                    text = "${itemsOrder.price} Dhs",
                    fontSize = nameSize.sp,
                   // style = TextStyle(textAlign = TextAlign.End),
                    maxLines = 1,
                    color = AppColor.DesertWhite,


                    )
            }

        }


        IconButton(
            modifier =    Modifier.align(Alignment.TopEnd),

            onClick = {
                itemRemove()

            },
            colors = IconButtonDefaults.iconButtonColors(containerColor = AppColor.RedError, contentColor = AppColor.DesertWhite)

        ) {
            Icon(
                imageVector = Icons.Rounded.Close,
                contentDescription = null,
                tint = AppColor.DesertWhite
            )
        }
    }
    }




