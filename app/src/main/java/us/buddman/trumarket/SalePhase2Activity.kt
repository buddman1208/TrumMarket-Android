package us.buddman.trumarket

import android.content.Intent
import android.net.Uri
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.widget.ImageView
import android.widget.LinearLayout
import com.afollestad.materialdialogs.DialogAction
import com.afollestad.materialdialogs.MaterialDialog
import com.github.nitrico.lastadapter.LastAdapter
import gun0912.tedbottompicker.TedBottomPicker
import kotlinx.android.synthetic.main.activity_sale_phase2.*
import us.buddman.trumarket.databinding.BlankImageBinding
import us.buddman.trumarket.databinding.NotBlankImageBinding
import us.buddman.trumarket.utils.BaseActivity


class SalePhase2Activity : BaseActivity() {
    lateinit var adapter: LastAdapter
    lateinit var bottomPicker: TedBottomPicker
    lateinit var layoutManager: LinearLayoutManager
    var imageList = ArrayList<Any>()
    var selectedPosition: Int = 0
    override fun setDefault() {
        setToolbarTitle("판매하기")
        imageList.add(0)
        nextFab.setOnClickListener {
            startActivity(Intent(applicationContext, SalePhase2Activity::class.java))
        }
        bottomPicker = TedBottomPicker.Builder(this@SalePhase2Activity)
                .setOnMultiImageSelectedListener { uriList: java.util.ArrayList<Uri> ->
                    uriList.forEach {
                        imageList.add(it.toString())
                    }
                    adapter.notifyDataSetChanged()
                }
                .create()
        layoutManager = LinearLayoutManager(this)
        layoutManager.orientation = RecyclerView.HORIZONTAL
        imageRecyclerView.layoutManager = layoutManager
        adapter = LastAdapter(imageList, BR.content)
                .map<Int, BlankImageBinding>(R.layout.blank_image) {
                    onClick { bottomPicker.show(supportFragmentManager) }
                }
                .map<String, NotBlankImageBinding>(R.layout.not_blank_image) {
                    onBind {
                        it.binding.imageInside.scaleType = ImageView.ScaleType.CENTER_CROP
                        it.binding.imageInside.setImageURI(Uri.parse(imageList[it.adapterPosition] as String)) }
                    onClick {
                        MaterialDialog.Builder(this@SalePhase2Activity)
                                .title("삭제하시겠습니까?")
                                .positiveText("삭제")
                                .onPositive { _, _ ->
                                    imageList.removeAt(it.adapterPosition)
                                    adapter.notifyItemRemoved(it.adapterPosition)
                                }
                                .show()
                    }
                }
                .into(imageRecyclerView)

    }

    override val onCreateViewId: Int = R.layout.activity_sale_phase2
    override val onCreateViewToolbarId: Int = R.id.toolbar

}
