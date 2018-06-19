package it.altralogica.zoomlayoutinsideviewpager

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.view.PagerAdapter
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val adapter = MyPagerAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        pager.adapter = adapter

        window.clearFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN)
        supportActionBar?.hide()

        // set screen always on
        window.addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON)

    }

    class MyPagerAdapter: PagerAdapter() {
        override fun isViewFromObject(view: View, obj: Any): Boolean {
            return view == obj
        }

        override fun getCount(): Int {
            return 5
        }

        override fun instantiateItem(container: ViewGroup, position: Int): Any {
            val page = Page(container.context)
            page.setImage(position)
            container.addView(page)
            return page
        }

        override fun destroyItem(container: ViewGroup, position: Int, obj: Any) {
            var page = obj as Page
            page.disposeImage()
            container.removeView(obj as View)
        }
    }
}
