package za.co.fredkobo.easyshoppinglist.dialog

import za.co.fredkobo.easyshoppinglist.model.ShoppingList

interface CreateListDialogInterface {
    fun createNewList(shoppingList: ShoppingList)
}