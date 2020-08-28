package com.androiddevs.mvvmnewsapp.repository

import com.androiddevs.mvvmnewsapp.api.RetrofitInstance
import com.androiddevs.mvvmnewsapp.data.ArticleDatabase
import com.androiddevs.mvvmnewsapp.models.Article
import retrofit2.Retrofit

class NewsRepository(
    val db: ArticleDatabase
) {
    suspend fun getBreakingNews(countryCode: String, pageNumber: Int) =
        RetrofitInstance.api.getBreakingNews(countryCode, pageNumber)

    suspend fun searchNews(countryCode: String, searchQuery: String, pageNumber: Int) =
        RetrofitInstance.api.searchForNews(countryCode, searchQuery, pageNumber)

    suspend fun insertOrUpdate(article:Article) = db.gatArticleDao().insertOrUpdate(article)

    fun getSavedNews() = db.gatArticleDao().getAllArticles()

    suspend fun deleteArticle(article: Article) = db.gatArticleDao().deleteArticle(article)
}