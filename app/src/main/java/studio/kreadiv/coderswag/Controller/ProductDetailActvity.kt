package studio.kreadiv.coderswag.Controller

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_product_detail_actvity.*
import studio.kreadiv.coderswag.Model.Product
import studio.kreadiv.coderswag.R
import studio.kreadiv.coderswag.Utilities.EXTRA_PRODUCT

class ProductDetailActvity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product_detail_actvity)

        val product = intent.getParcelableExtra<Product>(EXTRA_PRODUCT)

        val resourceId = this.resources.getIdentifier(product.image, "drawable"
                ,this.packageName)
        productDetailImage?.setImageResource(resourceId)
        productDetailTitle?.text = product.title
        productDetailPrice?.text = product.price

        addToCartBtn.setOnClickListener {
            Toast.makeText(this, "${product.title} was add to your cart!", Toast.LENGTH_SHORT).show()
        }
    }
}
