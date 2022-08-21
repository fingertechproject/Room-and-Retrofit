package com.example.myroom.model

import com.example.myroom.model.Articles

data class News(
    val totalResults:Int,
    val articles:List<Articles>
)
