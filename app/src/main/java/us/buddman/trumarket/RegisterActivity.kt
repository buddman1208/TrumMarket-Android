package us.buddman.trumarket

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_register.*
import us.buddman.trumarket.utils.BaseActivity

class RegisterActivity : BaseActivity() {
    override fun setDefault() {
        setToolbarTitle("회원가입")
        registerButton.setOnClickListener {
        }
    }

    override val onCreateViewId: Int = R.layout.activity_register
    override val onCreateViewToolbarId: Int = 0
}
