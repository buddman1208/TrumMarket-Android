package us.buddman.trumarket

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter
import kotlinx.android.synthetic.main.activity_main.*
import us.buddman.trumarket.fragments.MainMore
import us.buddman.trumarket.fragments.MainMy
import us.buddman.trumarket.fragments.MainStore
import us.buddman.trumarket.utils.BaseActivity

class MainActivity : BaseActivity() {
    override val onCreateViewId: Int = R.layout.activity_main
    override val onCreateViewToolbarId = 0
    lateinit var pagerAdapter: MainPagerAdapter
    override fun setDefault() {
        pagerAdapter = MainPagerAdapter(supportFragmentManager)
        mainPager.adapter = pagerAdapter
        mainPager.offscreenPageLimit = 4
        mainPager.setPagingEnabled(false)
        mainBottomBar.setOnTabSelectListener { tabId: Int ->
            when (tabId) {
                R.id.nav_market -> mainPager.currentItem = 0
                R.id.nav_my -> mainPager.currentItem = 1
                R.id.nav_more -> mainPager.currentItem = 2
            }
        }
        mainPager.currentItem = 0
        mainBottomBar.setDefaultTab(R.id.nav_market)
    }

    class MainPagerAdapter(fm: FragmentManager) : FragmentStatePagerAdapter(fm) {
        override fun getItem(position: Int): Fragment? {

            return when (position) {
                0 -> MainStore()
                1 -> MainMy()
                2 -> MainMore()
                else -> null
            }
        }

        override fun getCount(): Int {
            return 3
        }

        override fun getPageTitle(position: Int): CharSequence {
            return ""
        }
    }
}
