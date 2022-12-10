package com.ema.dummyjson.view

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.navigation.Navigation
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


        holder.container.setOnClickListener {
            navigateAndSendDataToDescriptionFragment(product.brand,product.description,product.discountPercentage,product.price,product.rating,product.images,it)
        }
    }

    override fun getItemCount(): Int {
        return productList.size
    }

    fun updateProduct(updatedProductList: MutableList<Product>) {
        productList = updatedProductList
    }

    private fun navigateAndSendDataToDescriptionFragment(
        brand: String,
        description: String,
        discount: Double,
        price: Int,
        rating: Double,
        image: List<String>,
        view: View
    ) {
        val action = ProductsFragmentDirections.actionProductsFragmentToDescriptionFragment(
            brand, description,
            discount.toFloat(), price, rating.toFloat(), image.toTypedArray()
        )
        Navigation.findNavController(view).navigate(action)
    }

    inner class MViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val container: ConstraintLayout
        val tvTitle: AppCompatTextView
        val tvPrice: AppCompatTextView
        val iv: AppCompatImageView

        init {
            tvTitle = itemView.findViewById(R.id.tv_title_item_products)
            tvPrice = itemView.findViewById(R.id.tv_price_item_products)
            iv = itemView.findViewById(R.id.iv_item_products)
            container = itemView.findViewById(R.id.constraint_container_item)
        }
    }


}