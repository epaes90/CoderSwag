package studio.kreadiv.coderswag.Controller

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import studio.kreadiv.coderswag.R
import studio.kreadiv.coderswag.Utilities.EXTRA_CATEGORY

class ProductsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_products)

        val categoryType = intent.getStringExtra(EXTRA_CATEGORY)
    }
}
