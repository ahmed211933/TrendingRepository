package com.ahmed.trending_task.trending.data.source.remote

import com.ahmed.trending_task.trending.data.model.response.GithubResponse
import com.ahmed.trending_task.trending.domain.entity.MakeenParams
import io.reactivex.Single
import javax.inject.Inject

class MakeenRemoteDataSource @Inject constructor(
    private val makeenApiService: MakeenApiService
) {

     fun fetchMakeen(params: MakeenParams): Single<ArrayList<GithubResponse>> {
         return makeenApiService.getRepositories(
             params.language,
             params.since,
             params.spoken_language_code,
         )
     }

}