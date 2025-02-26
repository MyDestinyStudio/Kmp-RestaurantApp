
package my.destiny.studio.restaurantapp.screens.orders.presentation



import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.grid.rememberLazyGridState
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Surface
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.TabRowDefaults
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.key
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import my.destiny.studio.restaurantapp.core.presentation.AppColor
import my.destiny.studio.restaurantapp.screens.admin.presentation.ItemsOrderCard
import my.destiny.studio.restaurantapp.screens.admin.presentation.ItemsOrderCartCard
import my.destiny.studio.restaurantapp.screens.orders.domain.FoodCategory
import my.destiny.studio.restaurantapp.screens.orders.domain.ItemsOrder
import my.destiny.studio.restaurantapp.screens.orders.domain.listOfFoodCategory
import my.destiny.studio.restaurantapp.screens.orders.domain.listOfItemsOrder
import org.jetbrains.compose.resources.painterResource


data class OrderScreenUi(
    val foodCategory: List<FoodCategory> = listOfFoodCategory,
    val selectedTabIndex: Int = 0,
    val foodOrder: List< ItemsOrder> = emptyList(),
                        )


sealed interface OrderScreenAction {
   data class OnTabSelected(val index: Int): OrderScreenAction
    data class OnItemSelected(val item: ItemsOrder): OrderScreenAction
    data class OnItemRemove(val itemIndex: Int): OrderScreenAction
    data object OnConfirmOrder: OrderScreenAction
    data object OnCancelOrder: OrderScreenAction

}



@Composable
fun OrderScreen(

    state : OrderScreenUi,
    onOrderAction: (OrderScreenAction) -> Unit={}
){


    val pagerState = rememberPagerState { state.foodCategory.size }
    val gridState = rememberLazyGridState()


    LaunchedEffect(state.selectedTabIndex) {
        pagerState.animateScrollToPage(state.selectedTabIndex)
    }

    LaunchedEffect(pagerState.currentPage) {
          onOrderAction(OrderScreenAction.OnTabSelected(pagerState.currentPage))
    }

    Surface(modifier = Modifier.fillMaxSize(), color = AppColor.DesertWhite){


        Row {

           OrderConfirmation(
                                  modifier = Modifier.weight(0.3f),
                                 listOfOrder = state.foodOrder,
                                 removeItemOrder = {onOrderAction(OrderScreenAction.OnItemRemove( it))},
                                 cancelOrder ={onOrderAction(OrderScreenAction.OnCancelOrder)     } ,
                                 confirmOrder ={onOrderAction(OrderScreenAction.OnConfirmOrder )  }
           )
            Column(modifier = Modifier.weight(0.7f), horizontalAlignment = Alignment.CenterHorizontally) {

                TabRow(
                    modifier = Modifier.fillMaxWidth().height(140.dp),
                    selectedTabIndex = state.selectedTabIndex,
                    indicator = { tabPositions ->
                        TabRowDefaults.SecondaryIndicator(
                            color = AppColor.DollarBill,
                            height = 3.dp,
                            modifier = Modifier
                                .tabIndicatorOffset(tabPositions[state.selectedTabIndex])
                        )
                    },
                    divider = {
                        HorizontalDivider(
                            modifier = Modifier.fillMaxWidth(),
                            thickness = 2.dp
                        )
                    }
                ) {

                    state.foodCategory.forEachIndexed {

                            index, foodCategory ->


                        Tab(
                            selected = state.selectedTabIndex == index,
                            onClick = { onOrderAction(OrderScreenAction.OnTabSelected(index)) },
                            modifier = Modifier.weight(1f),
                            selectedContentColor = AppColor.MayGreen,
                            unselectedContentColor = AppColor.DollarBill.copy(alpha = 0.5f)
                        ) {

                            Image(
                                painter = painterResource(foodCategory.image),
                                contentScale = ContentScale.Crop,
                                modifier = Modifier.height(100.dp).aspectRatio(1f),
                                contentDescription = null
                            )
                            Text(
                                text = foodCategory.foodName,
                                modifier = Modifier.padding(
                                    vertical = 12.dp
                                )
                            )
                        }

                    }


                }
                Spacer(Modifier.height(3.dp).fillMaxWidth())


                HorizontalPager(
                    state = pagerState,
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f)
                ) { pageIndex ->


                    Row {
                        LazyVerticalGrid(
                            modifier = Modifier.padding(7.dp),
                            state = gridState,
                            columns = GridCells.Fixed(4),
                            verticalArrangement = Arrangement.spacedBy(10.dp),
                            horizontalArrangement = Arrangement.spacedBy(10.dp)
                        ) {

                            items(
                                listOfItemsOrder.filter { it.category == state.foodCategory[pageIndex].foodName }
                            ) {


                                    itemToOrder ->

                                ItemsOrderCard(
                                    itemsOrder = itemToOrder,
                                    itemClicked = {
                                        onOrderAction(
                                            OrderScreenAction.OnItemSelected(
                                                it
                                            )
                                        )
                                    }

                                )


                            }


                        }


                    }
                }
            }
        }



    }

}


@Composable
fun OrderConfirmation(


    modifier: Modifier=Modifier,
    listOfOrder: List<ItemsOrder>,
    removeItemOrder : (Int)->Unit={},
    cancelOrder : ( )->Unit={},
    confirmOrder : ( )->Unit={}


                    ){

    val listState = rememberLazyListState()

    Card(modifier = modifier ,
        colors = CardDefaults.cardColors(containerColor = AppColor.DesertWhite),

    ){


        LazyColumn (

             state = listState,
            modifier =  Modifier.weight(1f).fillMaxHeight().padding(horizontal = 3.dp),
        //    verticalArrangement = Arrangement.spacedBy(4.dp),
            horizontalAlignment = Alignment.CenterHorizontally

               ){


            itemsIndexed(listOfOrder ){
                                      index, itemOrder ->
                key(  itemOrder.foodName ){

                    ItemsOrderCartCard(
                        itemsOrder = itemOrder,
                        itemRemove = {  removeItemOrder(index)   },
                        nameSize = 17
                    )
                }


            }


        }
        Button(
            modifier =   Modifier.align(Alignment.CenterHorizontally)
                .height(70.dp)
                .fillMaxWidth()
                .padding(start =20.dp,end = 20.dp,top = 3.dp),

            onClick ={     cancelOrder()                    } ,
            shape = RoundedCornerShape(10.dp),
            elevation = ButtonDefaults.buttonElevation(defaultElevation = 10.dp),

            colors = ButtonDefaults.buttonColors(
                containerColor = AppColor.RedError,
                disabledContentColor = AppColor.GrayError,
                disabledContainerColor = AppColor.GrayError.copy(0.1f)
            ),
            enabled = listOfOrder.isNotEmpty()

        ){
            Text(text = "Cancel Order")
        }
        Button(
            modifier =   Modifier.align(Alignment.CenterHorizontally)
                .height(70.dp)
                .fillMaxWidth()
                .padding(start =20.dp,end = 20.dp,top = 3.dp, bottom = 3.dp),

            onClick ={         confirmOrder()                } ,
            shape = RoundedCornerShape(10.dp),
            elevation = ButtonDefaults.buttonElevation(defaultElevation = 10.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = AppColor.MayGreen,
                disabledContentColor = AppColor.CrayolaLemon,
                disabledContainerColor = AppColor.CrayolaLemon.copy(0.1f)
            ),
            enabled = listOfOrder.isNotEmpty()

        ){
            Text(text = "Confirm Order")
        }





    }



}




