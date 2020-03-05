package algo.kelvin.ht373.rv.hbf.rb_recyclerview

import android.content.Context
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.util.ArrayList

fun <H, B> RecyclerView.recyclerViewHeaderBody(list: ArrayList<Any>, context: Context, layoutHeader: Int, layoutBody: Int, setDataRecyclerViewHB: SetupRecyclerViewHeaderBody<H, B>.() -> Unit) {
    setDataRecyclerViewHB(SetupRecyclerViewHeaderBody(list, context, layoutHeader, layoutBody, this))
}

class Binding<T>(val viewItemData: View, val item: T?)

@Suppress("UNCHECKED_CAST")
data class SetupRecyclerViewHeaderBody<H, B>(val list: ArrayList<Any>, val context: Context, val layoutHeader: Int, val layoutBody: Int, private val recyclerView: RecyclerView) {
    private var adapterRecyclerViewHeaderBody = AdapterRecyclerViewHeaderBody(list, context, layoutHeader, layoutBody)

    fun dataItemBody(data: Binding<B>.() -> Unit) {
        adapterRecyclerViewHeaderBody.setDataItemBody(data as Binding<*>.() -> Unit)
    }

    fun dataItemHeader(data: Binding<H>.() -> Unit) {
        adapterRecyclerViewHeaderBody.setDataItemHeader(data as Binding<*>.() -> Unit)
    }

    fun setLayoutManager() {
        recyclerView.layoutManager = LinearLayoutManager(recyclerView.context)
    }

    fun setAdapter() {
        recyclerView.adapter = adapterRecyclerViewHeaderBody
    }
}