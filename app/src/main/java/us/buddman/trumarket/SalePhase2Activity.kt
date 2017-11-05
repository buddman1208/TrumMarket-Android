package us.buddman.trumarket

import android.content.Intent
import android.net.Uri
import android.support.v4.content.ContextCompat
import kotlinx.android.synthetic.main.activity_sale_phase2.*
import us.buddman.trumarket.utils.BaseActivity
import us.buddman.trumarket.views.CartaTagView
import gun0912.tedbottompicker.TedBottomPicker



class SalePhase2Activity : BaseActivity() {
    var imageList = ArrayList<Uri>()
    var selectedPosition: Int = 0
    override fun setDefault() {
        setToolbarTitle("판매하기")

        nextFab.setOnClickListener {
            startActivity(Intent(applicationContext, SalePhase2Activity::class.java))
        }
        val tedBottomPicker = TedBottomPicker.Builder(this@SalePhase2Activity)
                .setOnImageSelectedListener {
                    // here is selected uri
                }
                .create()

        tedBottomPicker.show(supportFragmentManager)
    }



    override val onCreateViewId: Int = R.layout.activity_sale_phase2
    override val onCreateViewToolbarId: Int = R.id.toolbar

}