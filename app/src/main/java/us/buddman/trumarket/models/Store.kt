package us.buddman.trumarket.models

import java.util.*

/**
 * Created by Chad Park on 2017-11-05.
 */
data class Store(
        var _id: String,
        var type: Int,
        var product_name: String,
        var photo: ArrayList<String>,
        var seller_description: String,
        var product_info: String,
        var scratch : Number,
        var damage: Number,
        var availability : Number,
        var in_korea : Number,
        var trade_type : Number,
        var original_price: Number,
        var peck_price : Number,
        var trade_place : String,
        var trade_when : Date,
        var bank_info : String,
        var receive_address : String,
        var current_status : Number,
        var requests : ArrayList<Request>
)