package za.co.fredkobo.easyshoppinglist

import za.co.fredkobo.easyshoppinglist.model.ShoppingList

interface ListItemClickListener {
    fun onItemClicked(shoppingList: ShoppingList)
}