package za.co.fredkobo.easyshoppinglist.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import za.co.fredkobo.easyshoppinglist.model.ShoppingListItem

class ListDetailViewModel : ViewModel() {

    private var _list: MutableList<ShoppingListItem> =
        mutableListOf(ShoppingListItem("Bread", false))

    val shoppingListItems: MutableLiveData<MutableList<ShoppingListItem>> by lazy {
        MutableLiveData<MutableList<ShoppingListItem>>()
    }

    init {
        shoppingListItems.value = _list
    }

    fun addNewItem(shoppingListItem: ShoppingListItem) {
        if (!_list.contains(shoppingListItem)) {
            _list.add(shoppingListItem)
            shoppingListItems.value = _list
        }
    }

    companion object {
        const val TAG = "ListDetailViewModel"
    }
}