package za.co.fredkobo.easyshoppinglist

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import android.widget.Toast

class ListDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_detail)
    }

    fun addItemClicked(view: View) {
        val nameEditText = findViewById<EditText>(R.id.et_add_list_item)
        if(nameEditText.text.toString().isNotEmpty()) {
            Toast.makeText(this, nameEditText.text.toString() + " to be added to list", Toast.LENGTH_SHORT).show()
            hideKeyboard()
        }
    }

    fun hideKeyboard() {
        val imm = this.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(currentFocus?.windowToken, 0)
    }
}