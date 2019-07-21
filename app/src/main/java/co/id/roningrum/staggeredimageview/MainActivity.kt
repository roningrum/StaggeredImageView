package co.id.roningrum.staggeredimageview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    var parentList : MutableList<ParentModel> = mutableListOf()
    var childModel : MutableList<ChildModel> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        showMockData()

    }

    private fun showMockData() {

        val rvParents : RecyclerView = rv_parent
        rvParents.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = ParentAdapter(parentList)
            iniData()
            rvParents.adapter = adapter
        }

    }

    private fun iniData() {
        val image = resources.obtainTypedArray(R.array.cold_image)
        val name = resources.getStringArray(R.array.titleDummy)

        for(i in name.indices){
            parentList.add(ParentModel(name[i], childModel))
            childModel.add(ChildModel(image.getResourceId(i, 0)))
        }


    }
}