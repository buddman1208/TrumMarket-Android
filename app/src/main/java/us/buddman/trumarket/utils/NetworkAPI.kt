package us.buddman.trumarket.utils


import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST

/**
 * Created by Junseok Oh on 2017-07-18.
 */

interface NetworkAPI {

    @GET("/header")
    fun requestHeader(@Header("header") header: String): Call<ResponseBody>

    @POST("/header")
    fun requestHeaderByPost(@Header("header") header: String): Call<ResponseBody>
}