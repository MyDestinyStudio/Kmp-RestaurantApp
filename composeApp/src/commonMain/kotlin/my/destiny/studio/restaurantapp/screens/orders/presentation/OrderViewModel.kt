package my.destiny.studio.restaurantapp.screens.orders.presentation


import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import my.destiny.studio.restaurantapp.screens.orders.domain.ItemsOrder

class OrderViewModel : ViewModel()   {

    private val _orderState = MutableStateFlow(OrderScreenUi())
     val orderState =  _orderState.asStateFlow()



    fun onOrderAction(action: OrderScreenAction)=viewModelScope.launch{

        when(action){

    is OrderScreenAction.OnTabSelected   -> {

         _orderState.value=_orderState.value.copy(selectedTabIndex =  action.index )
                                             }

     is OrderScreenAction.OnItemSelected -> {

           _orderState.value=_orderState.value.copy(foodOrder = addItemToOrderList(_orderState.value.foodOrder,action.item).toList() )

                                            }

     is  OrderScreenAction.OnItemRemove -> {

           _orderState.value=_orderState.value.copy(foodOrder = removeItemOrderList(_orderState.value.foodOrder,action.itemIndex)  )


                                           }

    is OrderScreenAction.OnConfirmOrder -> {

                                           }


    is OrderScreenAction.OnCancelOrder -> {

            _orderState.value=_orderState.value.copy(foodOrder = emptyList())

                                          }

        //When Ends
        } }



















//Helper Function
    private fun addItemToOrderList(orderList:  List<ItemsOrder>, newItem: ItemsOrder): MutableList<ItemsOrder> {
        val o =orderList.toMutableList()
        val existingItemIndex = o.indexOfFirst { it.foodName == newItem.foodName && it.category == newItem.category } // Define your criteria here
        if (existingItemIndex != -1) {
            // Item exists, increase quantity
            o[existingItemIndex]=o[existingItemIndex].copy(quantity =o[existingItemIndex].quantity ++)
        } else {
            // Item doesn't exist, add it to the list
            o.add(newItem)
        }
        return o
    }

    private fun removeItemOrderList(orderList:  List<ItemsOrder>, itemIndexToRemove: Int):  List<ItemsOrder> {
        val o =orderList.toMutableList()
        o.removeAt(itemIndexToRemove)
        return o.toList()
    }



}