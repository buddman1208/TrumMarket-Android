package us.buddman.trumarket.fragments

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.GridLayoutManager
import android.util.Log

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.github.nitrico.lastadapter.Holder
import com.github.nitrico.lastadapter.LastAdapter
import kotlinx.android.synthetic.main.fragment_mainstore.*
import us.buddman.trumarket.BR
import us.buddman.trumarket.R
import us.buddman.trumarket.SalePhase1Activity
import us.buddman.trumarket.databinding.MainStoreBinding
import us.buddman.trumarket.models.Store
import us.buddman.trumarket.views.CartaTagView
import java.util.*

class MainStore : Fragment() {

    var tabList = ArrayList<CartaTagView>()
    var storeList = ArrayList<Any>()
    lateinit var adapter: LastAdapter
    lateinit var gridLayoutManager: GridLayoutManager
    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater!!.inflate(R.layout.fragment_mainstore, container, false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initialize()
    }

    fun initialize() {
        tabList = arrayListOf(tag1, tag2, tag3, tag4, tag5, tag6, tag7, tag8, tag9, tag10, tag11)
        Collections.addAll(storeList, "", "", "", "", "", "", "", "")
        for (i in 0 until tabList.size) {
            tabList[i].setOnClickListener { updateList(i) }
        }
        gridLayoutManager = GridLayoutManager(context, 2)
        mainRecyclerView.layoutManager = gridLayoutManager
        adapter = LastAdapter(storeList, BR.content)
                .map<String, MainStoreBinding>(R.layout.main_store_content) {
                    onClick {
                        Log.e("asdf", it.adapterPosition.toString())
                    }
                }
                .into(mainRecyclerView)
        toolbar.title = "장터"
        toolbar.setTitleTextColor(Color.WHITE)
        mainFab.setOnClickListener {
            startActivity(Intent(context, SalePhase1Activity::class.java))
        }
    }

    fun updateList(a: Int) {

    }
}