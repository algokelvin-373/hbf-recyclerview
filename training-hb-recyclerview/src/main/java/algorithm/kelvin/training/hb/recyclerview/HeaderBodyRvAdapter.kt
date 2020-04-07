package algorithm.kelvin.training.hb.recyclerview

import android.content.Context
import android.graphics.Color
import android.util.TypedValue
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_body.view.*

class HeaderBodyRvAdapter(private val context: Context, private val dataGroup: ArrayList<String>, private val dataGroupChild: ArrayList<List<Dummy>>) : RecyclerView.Adapter<HeaderBodyRvAdapter.HeaderBodyRvViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HeaderBodyRvViewHolder {
        return HeaderBodyRvViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_body, parent, false))
    }

    override fun getItemCount() = dataGroup.size

    override fun onBindViewHolder(holder: HeaderBodyRvViewHolder, position: Int) {
        if (getSizeChild(dataGroupChild[position]) != 0) {
            holder.itemView.tv_header.apply {
                text = dataGroup[position]
                visibility = View.VISIBLE
            }

            dataGroupChild[position].forEach {
                val layout = holder.itemView.findViewById<LinearLayout>(R.id.itemBodyLayout)

                val nameGroup = TextView(context)
                nameGroup.layoutParams= LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT)
                nameGroup.text = it.memberGroup
                nameGroup.setTextSize(TypedValue.COMPLEX_UNIT_SP, 14f)
                nameGroup.setTextColor(Color.BLACK)
                layout?.addView(nameGroup)
            }
        }
    }

    private fun getSizeChild(dataGroupChild: List<Dummy>): Int {
        var data = 0
        dataGroupChild.forEach { if (it.statusGroup) data++ }
        return data
    }

    class HeaderBodyRvViewHolder(view: View) : RecyclerView.ViewHolder(view)
}