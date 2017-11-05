package us.buddman.trumarket

import android.content.Intent
import android.support.v4.content.ContextCompat
import kotlinx.android.synthetic.main.activity_sale_phase1.*
import us.buddman.trumarket.utils.BaseActivity
import us.buddman.trumarket.views.CartaTagView

class SalePhase1Activity : BaseActivity() {
    var tabList = ArrayList<CartaTagView>()
    var selectedPosition: Int = 0
    override fun setDefault() {
        setToolbarTitle("판매하기")
        tabList = arrayListOf(tag1, tag2, tag3, tag4, tag5, tag6, tag7, tag8, tag9, tag10, tag11)
        for (i in 0 until tabList.size) {
            tabList[i].setShapeColor(ContextCompat.getColor(applicationContext, R.color.colorPrimary))
            tabList[i].setOnClickListener {
                setChecked(i)
            }
        }
        setChecked(0)
        nextFab.setOnClickListener {
            startActivity(Intent(applicationContext, SalePhase1Activity::class.java))
        }
    }

    fun setChecked(position: Int) {
        selectedPosition = position
        for (i in 0 until tabList.size) {
            tabList[i].setFullMode(position == i)
        }
    }

    override val onCreateViewId: Int = R.layout.activity_sale_phase1
    override val onCreateViewToolbarId: Int = R.id.toolbar

}
