package it.altralogica.zoomlayoutinsideviewpager

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.FrameLayout
import android.widget.ImageView

/**
 * Created by Valerio Santinelli on 18/06/18.
 */

class Page @JvmOverloads constructor(
        context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : FrameLayout(context, attrs, defStyleAttr) {
    var imageNum: Int = 0

    init {
        LayoutInflater.from(context)
                .inflate(R.layout.page, this, true)
    }

    fun setImage(position: Int) {
        imageNum = position
        val image = findViewById<ImageView>(R.id.iv)
        if (imageNum == 0) {
            image.setImageResource(R.drawable.img_1)
        } else if (imageNum == 1) {
            image.setImageResource(R.drawable.img_2)
        } else if (imageNum == 2) {
            image.setImageResource(R.drawable.img_3)
        } else if (imageNum == 3) {
            image.setImageResource(R.drawable.img_4)
        } else if (imageNum == 4) {
            image.setImageResource(R.drawable.img_5)
        } else {
            image.setImageResource(R.drawable.img_1)
        }
    }

    fun disposeImage() {
        val image = findViewById<ImageView>(R.id.iv)
        image.setImageDrawable(null)
    }

}