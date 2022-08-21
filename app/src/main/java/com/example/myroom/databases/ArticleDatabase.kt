package com.example.myroom.databases

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.myroom.interfaces.NewsArticlesDao
import com.example.myroom.model.ArticlesLocal

@Database(entities = [ArticlesLocal::class], version = 1)
abstract class ArticleDatabase:RoomDatabase() {
    abstract fun newsArticlesDao(): NewsArticlesDao
}