package us.buddman.trumarket.models

/**
 * Created by Chad Park on 2017-11-05.
 */
data class Request(
        var _id : String,
        var store_id : String,
        var from : String,
        var price : Int,
        var pecked_price : Int
)
