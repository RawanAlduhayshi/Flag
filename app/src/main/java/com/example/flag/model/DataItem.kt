package com.example.flag.model

import com.squareup.moshi.Json

data class DataItem(

	@Json(name="flag")
	val flag: String? = null,

	@Json(name="name")
	val name: String? = null
)