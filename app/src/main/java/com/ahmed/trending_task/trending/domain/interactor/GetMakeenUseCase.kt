package com.ahmed.trending_task.trending.domain.interactor

import com.ahmed.trending_task.trending.data.model.response.GithubResponse
import com.ahmed.trending_task.trending.domain.entity.MakeenParams
import com.ahmed.trending_task.trending.domain.repsitory.MakeenRepository
import io.reactivex.Single
import javax.inject.Inject

class GetMakeenUseCase @Inject constructor(private val makeenRepository: MakeenRepository) {

    fun fetchMakeen(params: MakeenParams): Single<ArrayList<GithubResponse>> {
        return makeenRepository.fetchMakeen(params)
    }

}