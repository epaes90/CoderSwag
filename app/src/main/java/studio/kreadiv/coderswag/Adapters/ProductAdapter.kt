package studio.kreadiv.coderswag.Adapters

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import studio.kreadiv.coderswag.Model.Product
import studio.kreadiv.coderswag.R

class ProductAdapter(val context: Context, val products: List<Product>
                     , val itemClick: (Product) -> Unit)
    : RecyclerView.Adapter<ProductAdapter.ProductHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.product_list_item, parent, false)
        return ProductHolder(view)
    }

    override fun getItemCount(): Int {
        return products.count()
    }

    override fun onBindViewHolder(holder: ProductHolder, position: Int) {
        holder?.bindProduct(products[position], context, itemClick)
    }

    inner class ProductHolder(itemView: View?) : RecyclerView.ViewHolder(itemView){

        private val productImage = itemView?.findViewById<ImageView>(R.id.productImage)
        private val productName = itemView?.findViewById<TextView>(R.id.productTitle)
        private val productPrice = itemView?.findViewById<TextView>(R.id.productPrice)

        fun bindProduct(product: Product, context: Context, itemClick: (Product) -> Unit){
            val resourceId = context.resources.getIdentifier(product.image, "drawable"
                    ,context.packageName)
            productImage?.setImageResource(resourceId)
            productName?.text = product.title
            productPrice?.text = product.price
            itemView.setOnClickListener { itemClick(product) }
        }
    }
}