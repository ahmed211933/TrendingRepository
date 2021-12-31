package com.ahmed.trending_task.trending.presentation.di

import com.ahmed.trending_task.trending.data.repository.TrendingRepositoryImpl
import com.ahmed.trending_task.trending.data.source.remote.MakeenApiService
import com.ahmed.trending_task.trending.domain.repsitory.MakeenRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import retrofit2.Retrofit

@Module
@InstallIn(ActivityComponent::class)
class MakeenModule {

    @Provides
    fun providesMakeenRepository(makeenRepositoryImpl: TrendingRepositoryImpl): MakeenRepository = makeenRepositoryImpl

    @Provides
    fun providesMakeenApiService(builder: Retrofit.Builder): MakeenApiService {
        return builder.build().create(MakeenApiService::class.java)
    }


}