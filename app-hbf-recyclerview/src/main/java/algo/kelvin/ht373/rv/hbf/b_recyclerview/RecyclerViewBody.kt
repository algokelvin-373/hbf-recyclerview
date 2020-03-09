package algo.kelvin.ht373.rv.hbf.b_recyclerview

import android.content.Context
import androidx.recyclerview.widget.RecyclerView

fun <B> RecyclerView.recyclerViewBody(list: ArrayList<Any>, context: Context, layoutBody: Int, setDataRecyclerViewHB: SetupRecyclerViewBody<B>.() -> Unit) {
    setDataRecyclerViewHB(SetupRecyclerViewBody(list, context, layoutBody, this))
}

data class SetupRecyclerViewBody<B>(val list: ArrayList<Any>, val context: Context, val layoutBody: Int, private val recyclerView: RecyclerView) {

}