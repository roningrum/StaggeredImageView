package co.id.roningrum.staggeredimageview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import kotlinx.android.synthetic.main.item_view_parent.view.*

class ParentAdapter(private  val parentModels : List<ParentModel>): RecyclerView.Adapter<ParentAdapter.ParentViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ParentViewHolder {
        return ParentViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_view_parent, parent, false))
    }

    override fun getItemCount(): Int {
        return parentModels.size
    }

    override fun onBindViewHolder(holder: ParentViewHolder, position: Int) {
        val parents = parentModels[position]
        holder.titleDummyView.text = parents.title
        holder.recyclerView.apply {
//            addItemDecoration(GridItemDecoration(10,3))
            layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.HORIZONTAL)
            adapter = ChildAdapter(parents.children)
        }
    }


    inner class ParentViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val recyclerView : RecyclerView = itemView.rv_image_child
        val titleDummyView: TextView = itemView.tv_Title

    }

}