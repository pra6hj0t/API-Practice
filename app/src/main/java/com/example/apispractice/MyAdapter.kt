package com.example.apispractice

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Switch
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import de.hdodenhof.circleimageview.CircleImageView

class MyAdapter(val context : Activity,val productArrayList: List<Product>):
RecyclerView.Adapter<MyAdapter.MyViewHolder>(){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.each_row,parent,false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
       return productArrayList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = productArrayList[position]

        holder.pName.text = currentItem.title
        //for image url

            Picasso.get().load(currentItem.thumbnail).into(holder.image)
        if (currentItem.rating.toInt() == 4){
            holder.star.text = "****"
        }else{
            holder.star.text = "*"
        }
    }

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val image = itemView.findViewById<CircleImageView>(R.id.productImage)
        val pName = itemView.findViewById<TextView>(R.id.productTitle)
        val star = itemView.findViewById<TextView>(R.id.ratingStar)
    }
}