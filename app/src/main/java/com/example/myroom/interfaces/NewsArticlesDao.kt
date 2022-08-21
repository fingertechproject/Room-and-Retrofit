package com.example.myroom.interfaces

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.myroom.model.ArticlesLocal

@Dao
interface NewsArticlesDao {
    @Insert
    suspend fun insertArticle(articles: ArticlesLocal)
    @Delete
   suspend  fun deleteArticles(articles: ArticlesLocal)
    @Insert
   suspend  fun insertAllArticles(articles: List<ArticlesLocal>)
    @Query("select*from article")
    fun getAllArticles():LiveData<List<ArticlesLocal>>
}