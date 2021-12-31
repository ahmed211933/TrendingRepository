package com.ahmed.trending_task.trending.domain.repsitory


import com.ahmed.trending_task.trending.data.model.response.GithubResponse
import com.ahmed.trending_task.trending.domain.entity.MakeenParams
import io.reactivex.Single

interface MakeenRepository {
    fun fetchMakeen(params: MakeenParams): Single<ArrayList<GithubResponse>>
}