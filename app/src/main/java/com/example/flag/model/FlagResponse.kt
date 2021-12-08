package com.example.flag.model

import com.squareup.moshi.Json

data class FlagResponse(@Json(name = "error")  val error: Boolean, @Json(name = "msg") val msg:String, @Json(name = "data")  val data: List<DataItem>)
