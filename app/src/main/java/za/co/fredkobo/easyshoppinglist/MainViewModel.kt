package za.co.fredkobo.easyshoppinglist

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlin.collections.ArrayList


class MainViewModel: ViewModel() {

    private var _list: MutableList<ShoppingList>
    = mutableListOf(ShoppingList("Picknick shopping", System.currentTimeMillis(), ArrayList()))

    val listOfShoppingLists: MutableLiveData<MutableList<ShoppingList>> by lazy {
        MutableLiveData<MutableList<ShoppingList>>()
    }

    init {
        listOfShoppingLists.value = _list
    }

    fun addNewList(shoppingList: ShoppingList) {
        if (!_list.contains(shoppingList)) {
            _list.add(shoppingList)
            listOfShoppingLists.value = _list
        }
    }

}