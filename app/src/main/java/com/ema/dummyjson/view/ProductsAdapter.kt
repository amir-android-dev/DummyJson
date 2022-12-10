package com.ema.dummyjson.view

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.RecyclerView
import com.ema.dummyjson.R
import com.ema.dummyjson.model.Product
import com.squareup.picasso.Picasso

class ProductsAdapter(var context: Context, var productList: MutableList<Product>) :
    RecyclerView.Adapter<ProductsAdapter.MViewHolder>() {

    interface Callback {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.item_product, parent, false)
        return MViewHolder(view)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: MViewHolder, position: Int) {
        val product = productList[position]
        holder.tvPrice.text = "$ ${product.price}"
        holder.tvTitle.text = product.title
        Picasso.get().load(product.images[0]).into(holder.iv)

        val imagesIterator = product.images.listIterator()

        var iForward = 1
        holder.ivForward.setOnClickListener {
            when (iForward) {
                in 1 until (product.images.size) -> {
                    holder.iv.tag = product.images[iForward]
                    Picasso.get().load(product.images[iForward]).into(holder.iv)
                    iForward++
                    if (iForward == product.images.size) {
                        iForward = 0
                    }
                }
            }
        }

        var iBack = iForward
        holder.ivBack.setOnClickListener {
           when(iBack){
               in iForward .. 0 ->{
                   holder.iv.tag = product.images[iBack]
                   Picasso.get().load(product.images[iBack]).into(holder.iv)
                   iBack--
                   if (iBack == product.images.size) {
                       iBack = product.images.size
                   }
               }
           }
        }



    }

    override fun getItemCount(): Int {
        return productList.size
    }

    fun updateProduct(updatedProductList: MutableList<Product>) {
        productList = updatedProductList
    }

    inner class MViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val tvTitle: AppCompatTextView
        val tvPrice: AppCompatTextView
        val iv: AppCompatImageView
        val ivBack: AppCompatImageView
        val ivForward: AppCompatImageView

        init {
            tvTitle = itemView.findViewById(R.id.tv_title_item_products)
            tvPrice = itemView.findViewById(R.id.tv_price_item_products)
            iv = itemView.findViewById(R.id.iv_item_products)
            ivBack = itemView.findViewById(R.id.iv_back_item_products)
            ivForward = itemView.findViewById(R.id.iv_forward_item_products)
        }
    }


}