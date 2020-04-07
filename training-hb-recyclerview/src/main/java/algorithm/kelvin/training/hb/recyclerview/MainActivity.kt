package algorithm.kelvin.training.hb.recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val dataDummy = getDataDummy()
        val mapList = HashMap<String, List<Dummy>>()
        var title = dataDummy[0].group
        var xChildStart = 0
        var xChildFinish = 0
        var x = 0
        dataDummy.forEach {
            if (title != it.group) {
                if (x == 0) title = it.group
                else {
                    mapList[title] = (xChildStart until xChildFinish).map { i -> dataDummy[i] }
                    title = it.group
                    xChildStart = xChildFinish
                }
            }
            else if (x == dataDummy.size-1) mapList[title] = (xChildStart..xChildFinish).map { i -> dataDummy[i] }
            xChildFinish++
            x++
        }

        val keyList = ArrayList(mapList.keys)
        val valueList = ArrayList(mapList.values)

        rvItem.apply {
            this.layoutManager = LinearLayoutManager(this@MainActivity)
            this.adapter = HeaderBodyRvAdapter(this@MainActivity, keyList, valueList)
        }
    }
}
