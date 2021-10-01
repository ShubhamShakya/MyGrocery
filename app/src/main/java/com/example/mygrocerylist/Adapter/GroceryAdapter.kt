package com.example.mygrocerylist.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mygrocerylist.GroceryItems
import com.example.mygrocerylist.UI.GroceryViewModel
import com.example.mygrocerylist.R

import kotlinx.android.synthetic.main.groceryadapter.view.*


class GroceryAdapter (var list:List<GroceryItems>, var viewModel: GroceryViewModel):
    RecyclerView.Adapter<GroceryAdapter.GroceryViewHolder>() {


        /*val txtItemName=itemView.findViewById<TextView>(R.id.txtItemName);
        val txtItemPrice=itemView.findViewById<TextView>(R.id.txtItemPrice);
        val txtItemQuantity=itemView.findViewById<TextView>(R.id.txtItemQuantity)
        val ibDelete=itemView.findViewById<ImageFilterButton>(R.id.ibDelete);
        val txtItemTotalCost=itemView.findViewById<TextView>(R.id.txtItemTotalCost);
        val txtTotalCostTitle=itemView.findViewById<TextView>(R.id.txtTotalCostTitle);*/



    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): GroceryAdapter.GroceryViewHolder {
        val view= LayoutInflater.from(parent.context).inflate(R.layout.groceryadapter,parent,false)
        return GroceryViewHolder(view)
    }

    override fun onBindViewHolder(holder: GroceryViewHolder, position: Int) {
        var currentPosition = list[position]

        holder.itemView.txtItemName.text = currentPosition.itemName
        holder.itemView.txtItemPrice.text = "${currentPosition.itemPrice}"
        holder.itemView.txtItemQuantity.text = "${currentPosition.itemQuantity}"
        holder.itemView.ibDelete.setOnClickListener {
            viewModel.delete(currentPosition)
        }
        if (position == list.size - 1) {
            var totalCost = 0
            for (i in 0 until list.size) {
                totalCost += list[i].itemPrice
            }
            holder.itemView.txtItemTotalCost.visibility = View.VISIBLE
            holder.itemView.txtTotalCostTitle.visibility = View.VISIBLE
            holder.itemView.txtItemTotalCost.text = "$totalCost"

        }
    }

    override fun getItemCount(): Int {
        return list.size
    }
    inner class GroceryViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

}