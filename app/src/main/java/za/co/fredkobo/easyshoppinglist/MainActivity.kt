package za.co.fredkobo.easyshoppinglist

import android.content.Intent
import android.graphics.drawable.ClipDrawable.HORIZONTAL
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.RecyclerView


class MainActivity : AppCompatActivity(), CreateListDialogInterface, ListItemClickListener {

    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        val recyclerView = findViewById<RecyclerView>(R.id.recycler_view)
        recyclerView.addItemDecoration(DividerItemDecoration(this, HORIZONTAL))
        val adapter = ListOfListsAdapter(emptyList(), this)
        recyclerView.adapter = adapter

        val colourListObserver = Observer<MutableList<ShoppingList>> { list ->
            adapter.setNewList(list)
            Log.d(TAG, "New List: " + list)
        }
        viewModel.listOfShoppingLists.observe(this, colourListObserver)

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