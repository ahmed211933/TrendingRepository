package com.ahmed.trending_task.trending.presentation.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

import com.ahmed.trending_task.trending.data.model.response.GithubResponse
import com.ahmed.trending_task.trending.domain.entity.MakeenParams
import com.ahmed.trending_task.trending.domain.interactor.GetMakeenUseCase
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.addTo
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class MakeenViewModel @Inject constructor(
    private val refreshForecastUseCase: GetMakeenUseCase
): ViewModel() {

    private val compositeDisposable = CompositeDisposable()

    val screenState by lazy {MutableLiveData<ScreenState>() }


    fun getMakeenItems() {
        screenState.value = ScreenState.Loading
        val params = MakeenParams("","","")
        refreshForecastUseCase.fetchMakeen(params)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                handleSuccessResponse(it)
            }, {
                handleErrorResponse(it)
            }).addTo(compositeDisposable)
    }


    fun handleErrorResponse(it: Throwable) {

        screenState.value = ScreenState.ErrorLoadingFromApi(it)
    }

    private fun handleSuccessResponse(it: ArrayList<GithubResponse>) {
        screenState.value = ScreenState.SuccessAPIResponse(it)
    }

    sealed class ScreenState {
        object Loading : ScreenState()
        class SuccessAPIResponse(val data: ArrayList<GithubResponse>) : ScreenState()
        class ErrorLoadingFromApi(val error: Throwable) : ScreenState()
    }

    override fun onCleared() {
        compositeDisposable.dispose()
        super.onCleared()
    }
}