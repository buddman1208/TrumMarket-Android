package us.buddman.trumarket

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.view.View.VISIBLE
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.RelativeLayout
import kotlinx.android.synthetic.main.activity_splash.*
import android.view.animation.AnimationUtils
import android.view.animation.Animation


class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        startActivity(Intent(applicationContext, MainActivity::class.java))
        finish()
        originateLayout(0)
        login.setOnClickListener {
            startActivity(Intent(applicationContext, AuthActivity::class.java))
        }
        register.setOnClickListener {
            startActivity(Intent(applicationContext, RegisterActivity::class.java))
        }
    }

    fun originateLayout(weight: Int) {
            bottomContainer.layoutParams = LinearLayout.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT, 0, weight + 0f
            )
            if (weight < 120) Handler().postDelayed({ originateLayout(weight + 1) }, 4)
            else {
                val fadeInAnimation = AnimationUtils.loadAnimation(this, R.anim.fade_in_anim)
                fadeInAnimation.fillAfter = true
                bottomContainer.startAnimation(fadeInAnimation)
            }
    }
}
