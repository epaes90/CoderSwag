package studio.kreadiv.coderswag.Controller

import android.content.res.Configuration
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.widget.GridLayout
import kotlinx.android.synthetic.main.activity_products.*
import studio.kreadiv.coderswag.Adapters.ProductAdapter
import studio.kreadiv.coderswag.R
import studio.kreadiv.coderswag.Services.DataService
import studio.kreadiv.coderswag.Utilities.EXTRA_CATEGORY

class ProductsActivity : AppCompatActivity() {

    lateinit var adapter : ProductAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_products)

        val categoryType = intent.getStringExtra(EXTRA_CATEGORY)

        adapter = ProductAdapter(this, DataService.getProduct(categoryType))

        val orientation = resources.configuration.orientation
        val screenSize = resources.configuration.screenWidthDp
        var spanCount = 2

        if(screenSize > 720){
            spanCount = 3
            if (orientation == Configuration.ORIENTATION_PORTRAIT){
                spanCount = 4
            }
        } else{
            if (orientation == Configuration.ORIENTATION_PORTRAIT){
                spanCount = 3
            }
        }

        val layoutManager = GridLayoutManager(this, spanCount)
        productListView.layoutManager = layoutManager
        productListView.adapter = adapter
    }
}
