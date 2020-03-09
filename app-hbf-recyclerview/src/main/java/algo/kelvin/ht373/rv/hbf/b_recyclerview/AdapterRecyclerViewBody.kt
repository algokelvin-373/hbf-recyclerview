package algo.kelvin.ht373.rv.hbf.b_recyclerview

import android.content.Context
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import java.util.ArrayList

class AdapterRecyclerViewBody(private val listData: ArrayList<Any>,
                              private val context: Context,
                              private val bodyLayout: Int): RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

    }

    override fun getItemCount(): Int = listData.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

    }

}