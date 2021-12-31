package com.ahmed.trending_task.trending.data.source.remote

import com.ahmed.trending_task.trending.data.model.response.GithubResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface MakeenApiService {




@GET("repositories")
    fun getRepositories(
        @Query("language") language:String ,
        @Query("since") since:String,
        @Query("spoken_language_code") spoken_language_code:String,

    ): Single<ArrayList<GithubResponse>>


}


