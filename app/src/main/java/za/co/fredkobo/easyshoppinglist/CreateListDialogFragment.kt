package za.co.fredkobo.easyshoppinglist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.DialogFragment

class CreateListDialogFragment : DialogFragment() {

    companion object {
        lateinit var createListInterface: CreateListDialogInterface
        fun newInstance(createListInterface: CreateListDialogInterface): CreateListDialogFragment {
            this.createListInterface = createListInterface
            return CreateListDialogFragment()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.dialog_create_new_shopping_list, container)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val nameEditText = view.findViewById<EditText>(R.id.et_shoppinglist_name)
        view.findViewById<Button>(R.id.btn_cancel).setOnClickListener { dismiss() }
        view.findViewById<Button>(R.id.btn_create).setOnClickListener { v ->
            if (nameEditText.text.toString().isNotEmpty()) {
                createListInterface.createNewList(
                    ShoppingList(
                        nameEditText.text.toString(),
                        System.currentTimeMillis(),
                        ArrayList()
                    )
                )
                dismiss()
            }
        }
    }
}