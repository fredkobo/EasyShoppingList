package za.co.fredkobo.easyshoppinglist

data class ShoppingList(
    var name: String,
    var lastEditDate: Long,
    var items: ArrayList<String>
)
