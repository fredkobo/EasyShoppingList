package za.co.fredkobo.easyshoppinglist.model

data class ShoppingList(
    var name: String,
    var lastEditDate: Long,
    var items: ArrayList<ShoppingListItem>
)
