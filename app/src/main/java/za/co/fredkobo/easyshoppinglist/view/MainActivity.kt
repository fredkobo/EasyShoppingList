package za.co.fredkobo.easyshoppinglist.view

import android.content.Intent
import android.graphics.drawable.ClipDrawable.HORIZONTAL
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.RecyclerView
import za.co.fredkobo.easyshoppinglist.ListItemClickListener
import za.co.fredkobo.easyshoppinglist.R
import za.co.fredkobo.easyshoppinglist.adapter.ListOfListsAdapter
import za.co.fredkobo.easyshoppinglist.dialog.CreateListDialogFragment
import za.co.fredkobo.easyshoppinglist.dialog.CreateListDialogInterface
import za.co.fredkobo.easyshoppinglist.model.ShoppingList
import za.co.fredkobo.easyshoppinglist.viewmodel.MainViewModel


class MainActivity : AppCompatActivity(), CreateListDialogInterface, ListItemClickListener {

    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        val recyclerView = findViewById<RecyclerView>(R.id.recycler_view_main)
        recyclerView.addItemDecoration(DividerItemDecoration(this, HORIZONTAL))
        val adapter = ListOfListsAdapter(emptyList(), this)
        recyclerView.adapter = adapter

        val shoppingListObserver = Observer<MutableList<ShoppingList>> { list ->
            adapter.setNewList(list)
        }
        viewModel.listOfShoppingLists.observe(this, shoppingListObserver)

    }

    fun createListFabClicked(view: View) {
        val fragment = CreateListDialogFragment.newInstance(this)
        fragment.show(supportFragmentManager, "CreateListDialogFragment")
    }

    override fun createNewList(shoppingList: ShoppingList) {
        viewModel.addNewList(shoppingList)
    }

    companion object {
        const val TAG = "MainActivity"
    }

    override fun onItemClicked(shoppingList: ShoppingList) {
        startActivity(Intent(this, ListDetailActivity::class.java))
    }
}