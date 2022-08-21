package com.example.myroom

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.room.Room
import com.example.myroom.databases.ArticleDatabase
import com.example.myroom.interfaces.NewsInterface
import com.example.myroom.model.Articles
import com.example.myroom.model.ArticlesLocal
import com.example.myroom.model.News
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    lateinit var database: ArticleDatabase
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        database = Room.databaseBuilder(applicationContext,
        ArticleDatabase::class.java,
        "articleDB").build()
        GlobalScope.launch {
            database.newsArticlesDao().insertArticle(ArticlesLocal(0,"kk,","kk","kk","kk","kk"))
        }
        val allNews = NewsInterface.newsInstance.getAllNews("in")
        allNews.enqueue(object :Callback<News>{
            override fun onResponse(call: Call<News>, response: Response<News>) {
               val news = response.body()
                if (news!=null){
                    GlobalScope.launch {

                        database.newsArticlesDao().insertAllArticles(news.articles as List<ArticlesLocal>)

                    }
                    Log.d("TAG",news.toString())
                }
            }

            override fun onFailure(call: Call<News>, t: Throwable) {
             Log.d("TAG",t.toString())
            }
        })
    }
}