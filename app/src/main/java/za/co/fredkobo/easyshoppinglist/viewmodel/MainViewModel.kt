package za.co.fredkobo.easyshoppinglist.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import za.co.fredkobo.easyshoppinglist.model.ShoppingList


class MainViewModel : ViewModel() {

    private var _list: MutableList<ShoppingList> =
        mutableListOf(ShoppingList("Picknick shopping", System.currentTimeMillis(), ArrayList()))

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