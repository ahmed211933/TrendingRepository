package com.ahmed.trending_task.trending.data.repository


import com.ahmed.trending_task.trending.data.model.response.GithubResponse
import com.ahmed.trending_task.trending.data.source.remote.MakeenRemoteDataSource
import com.ahmed.trending_task.trending.domain.entity.MakeenParams
import com.ahmed.trending_task.trending.domain.repsitory.MakeenRepository
import io.reactivex.Single
import javax.inject.Inject


class TrendingRepositoryImpl @Inject constructor(
    private val makeenRemoteDataSource: MakeenRemoteDataSource
) : MakeenRepository {

    override fun fetchMakeen(makeenParams: MakeenParams): Single<ArrayList<GithubResponse>> {
        return makeenRemoteDataSource.fetchMakeen(makeenParams)
    }



}
