package us.buddman.trumarket

import android.content.Intent
import android.util.Log
import android.widget.EditText
import android.widget.Toast
import com.facebook.CallbackManager
import com.facebook.FacebookCallback
import com.facebook.FacebookException
import com.facebook.FacebookSdk
import com.facebook.login.LoginResult
import kotlinx.android.synthetic.main.activity_auth.*
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import us.buddman.trumarket.utils.BaseActivity
import us.buddman.trumarket.utils.NetworkHelper

class AuthActivity : BaseActivity() {
    lateinit var callbackManager: CallbackManager
    override val onCreateViewId: Int = R.layout.activity_auth
    override val onCreateViewToolbarId = R.id.toolbar

    override fun setDefault() {
        setToolbarTitle("로그인")
        disableToggle()
        configureFacebook()
        configureLocalLogin()
    }

    fun configureFacebook() {
        callbackManager = CallbackManager.Factory.create()
        realFacebookLogin.setReadPermissions("email")
        realFacebookLogin.registerCallback(callbackManager, object : FacebookCallback<LoginResult> {
            override fun onSuccess(loginResult: LoginResult) {
                Log.e("asdf", loginResult.accessToken.token)
                // Login with Facebook
//                NetworkHelper.instance.requestHeader(loginResult.accessToken.token).enqueue(object : Callback<ResponseBody> {
//                    override fun onResponse(call: Call<ResponseBody>, response: Response<ResponseBody>) {
//                        when (response.code()) {
//                            200 -> {
//                            }
//                        }
//                    }
//
//                    override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
//                        Toast.makeText(this@AuthActivity, "로그인에 문제가 발생했습니다.", Toast.LENGTH_SHORT).show()
//                        Log.e("asdf", t.localizedMessage)
//                    }
//                })
            }

            override fun onCancel() {
                Log.e("asdf", "Canceled")

            }

            override fun onError(error: FacebookException) {
                Log.e("asdf", error.localizedMessage)

            }
        })
    }

    fun configureLocalLogin() {
        localLogin.setOnClickListener {
            if(emailInput.text.toString().trim() == "" || passwordInput.text.toString().trim() == "") Toast.makeText(applicationContext, "빈칸 없이 입력해주세요!", Toast.LENGTH_SHORT).show()
            else {

            }
        }
        facebookLogin.setOnClickListener{
            realFacebookLogin.performClick()
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        callbackManager.onActivityResult(requestCode, resultCode, data)
    }
}