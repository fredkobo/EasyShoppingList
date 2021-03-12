package za.co.fredkobo.easyshoppinglist.view

import android.content.Context
import android.graphics.drawable.ClipDrawable
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.RecyclerView
import za.co.fredkobo.easyshoppinglist.R
import za.co.fredkobo.easyshoppinglist.adapter.ShoppingListAdapter
import za.co.fredkobo.easyshoppinglist.model.ShoppingListItem
import za.co.fredkobo.easyshoppinglist.viewmodel.ListDetailViewModel

class ListDetailActivity : AppCompatActivity() {

    lateinit var viewModel: ListDetailViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_detail)

        viewModel = ViewModelProvider(this).get(ListDetailViewModel::class.java)

        val recyclerView = findViewById<RecyclerView>(R.id.recycler_view_detail)
        recyclerView.addItemDecoration(DividerItemDecoration(this, ClipDrawable.HORIZONTAL))
        val adapter = ShoppingListAdapter(emptyList())
        recyclerView.adapter = adapter

        val shoppingListObserver = Observer<MutableList<ShoppingListItem>> { list ->
            adapter.setNewList(list)
        }
        viewModel.shoppingListItems.observe(this, shoppingListObserver)
    }

    fun addItemClicked(view: View) {
        val nameEditText = findViewById<EditText>(R.id.et_add_list_item)
        if (nameEditText.text.toString().isNotEmpty()) {
            viewModel.addNewItem(ShoppingListItem(nameEditText.text.toString(), false))
            nameEditText.text.clear()
            hideKeyboard()
        }
    }

    fun hideKeyboard() {
        val imm = this.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(currentFocus?.windowToken, 0)
    }
}