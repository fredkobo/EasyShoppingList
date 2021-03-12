package za.co.fredkobo.easyshoppinglist.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import za.co.fredkobo.easyshoppinglist.ListItemClickListener
import za.co.fredkobo.easyshoppinglist.R
import za.co.fredkobo.easyshoppinglist.model.ShoppingList
import java.text.SimpleDateFormat
import java.util.*

class ListOfListsAdapter(
    var items: List<ShoppingList>,
    var itemClickListener: ListItemClickListener
) :
    RecyclerView.Adapter<ListOfListsAdapter.ShoppingListItemViewHolder>() {

    class ShoppingListItemViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private var dateTextView: TextView? = null
        private var nameTextView: TextView? = null

        init {
            dateTextView = itemView.findViewById(R.id.tv_date)
            nameTextView = itemView.findViewById(R.id.tv_list_name)
        }

        fun bind(shoppingList: ShoppingList) {
            val sdf = SimpleDateFormat("dd/MM/yyyy 'at' HH:mm", Locale.ENGLISH)
            val datetime = sdf.format(shoppingList.lastEditDate)
            dateTextView?.text = itemView.context.getString(R.string.last_edited, datetime)
            nameTextView?.text = shoppingList.name
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShoppingListItemViewHolder {
        return ShoppingListItemViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.list_tem_main, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ShoppingListItemViewHolder, position: Int) {
        val shoppingList: ShoppingList = items[position]
        holder.bind(shoppingList)
        holder.itemView.setOnClickListener {
            this.itemClickListener.onItemClicked(shoppingList)
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }

    fun setNewList(newList: MutableList<ShoppingList>) {
        this.items = newList
        notifyDataSetChanged()
    }
}