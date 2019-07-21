package co.id.roningrum.staggeredimageview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_view_child.view.*
import java.util.*


class ChildAdapter (private val childModel: List<ChildModel>): RecyclerView.Adapter<ChildAdapter.ChildViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int)= ChildViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_view_child, parent, false))

    override fun getItemCount(): Int =childModel.size

    override fun onBindViewHolder(holder: ChildViewHolder, position: Int) {
        holder.bindItem(childModel[position])
    }

    class ChildViewHolder (itemView: View) : RecyclerView.ViewHolder(itemView){
        private val mRandom = Random()
        private val imgView : ImageView = itemView.image_item_rv
         fun bindItem(childItems: ChildModel){
//             imgView.layoutParams.height = getRandomIntInRange(150, 150 )
             Picasso.get().load(childItems.image).into(imgView)
         }
        fun getRandomIntInRange(max: Int, min: Int): Int{
            return mRandom.nextInt(max - min + min) + min
        }
    }


}