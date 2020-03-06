package algo.kelvin.ht373.rv.hbf.rb_recyclerview

import algo.kelvin.ht373.rv.hbf.Province
import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import java.util.ArrayList

class AdapterRecyclerViewHeaderBody(private val listData: ArrayList<Any>,
                                    private val context: Context,
                                    private val headerLayout: Int,
                                    private val bodyLayout: Int): RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private lateinit var setupItemDataBody: Binding<*>.() -> Unit
    private lateinit var setupItemDataHeader: Binding<*>.() -> Unit
    private var itemData: Any? = null

    companion object {
        const val bodyView = 1
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val layoutInflater = LayoutInflater.from(context)
        return when(viewType) {
            bodyView -> DataViewHolder(layoutInflater.inflate(bodyLayout, parent, false))
            else -> DataViewHolder(layoutInflater.inflate(headerLayout, parent, false))
        }
    }

    override fun getItemCount(): Int = listData.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val itemHolder = holder as DataViewHolder
        Log.i("hbf-rv","${listData[position]}")
        itemData = listData[position]
        if (itemData != null) {
            try {
                when(itemData!!.type()) {
                    1 -> {
                        Log.e("hbf-rf", "Body RV")
                        itemHolder.setItemListData(setupItemDataBody, itemData, position)
                    }
                    0 -> {
                        Log.e("hbf-rf","Header RV")
                        itemHolder.setItemListData(setupItemDataHeader, itemData, position)
                    }
                }
            }
            catch (e: UninitializedPropertyAccessException) {
                throw IllegalArgumentException("'bind' is not working")
            }
        }
    }

    override fun getItemViewType(position: Int): Int {
        return listData[position].type()
    }

    fun setDataItemBody(bindingBody: Binding<*>.() -> Unit) {
        this.setupItemDataBody = bindingBody
    }

    fun setDataItemHeader(bindingHeader: Binding<*>.() -> Unit) {
        this.setupItemDataHeader = bindingHeader
    }

    private fun Any.type(): Int {
        return if (this is Province) 1
        else 0
    }

}

@Suppress("UNCHECKED_CAST")
class DataViewHolder(view: View): RecyclerView.ViewHolder(view) {
    fun setItemListData(setup: Binding<*>.() -> Unit, item: Any?, position: Int) = itemView.run {
        val setupData = Binding(this, item)
        setup(setupData)
    }
}

data class DefineTypeItemData<T: Any>(private val classDataItem: Class<T>) {
    companion object {
        inline operator fun <reified T : Any>invoke() = DefineTypeItemData(T::class.java)
    }
    fun checkItemData(t: Any): Int {
        return when {
            classDataItem.isAssignableFrom(t.javaClass) -> 1
            else -> 0
        }
    }
}