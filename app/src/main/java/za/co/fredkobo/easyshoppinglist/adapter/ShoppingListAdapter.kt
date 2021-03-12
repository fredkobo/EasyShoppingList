package za.co.fredkobo.easyshoppinglist.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import androidx.recyclerview.widget.RecyclerView
import za.co.fredkobo.easyshoppinglist.R
import za.co.fredkobo.easyshoppinglist.model.ShoppingListItem

class ShoppingListAdapter(var items: List<ShoppingListItem>) :
    RecyclerView.Adapter<ShoppingListAdapter.ShoppingListItemViewHolder>() {

    class ShoppingListItemViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private var checkBox: CheckBox? = null

        init {
            checkBox = itemView.findViewById(R.id.checkbox)
        }

        fun bind(shoppingListItem: ShoppingListItem) {
            checkBox?.isChecked = shoppingListItem.tickedoff
            checkBox?.text = shoppingListItem.name
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShoppingListItemViewHolder {
        return ShoppingListItemViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.list_item_detail, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ShoppingListItemViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int {
        return items.size
    }

    fun setNewList(newList: MutableList<ShoppingListItem>) {
        this.items = newList
        notifyDataSetChanged()
    }
}