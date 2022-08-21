package com.example.myroom.interfaces

import com.example.myroom.model.News
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query


//https://newsapi.org/v2/top-headlines?country=us&category=business&apiKey=a633d3b17ab64f5fb4fc9d3bc5e26f69
const val BASE_URL = "https://newsapi.org"
const val API_KEY = "a633d3b17ab64f5fb4fc9d3bc5e26f69"
interface NewsInterface {
    @GET("/v2/top-headlines?apiKey=$API_KEY")
    fun getAllNews(@Query("country") country:String):Call<News>

   companion object NewsInstace{
        var newsInstance:NewsInterface
        init {
            val retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            newsInstance = retrofit.create(NewsInterface::class.java)
        }
    }
}