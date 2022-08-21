package com.example.myroom.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "article")
data class ArticlesLocal(
    @PrimaryKey(autoGenerate = true)
    val id:Int,
    val author:String,
    val title:String,
    val description:String,
    val url:String,
    val urlToImage:String
)
