package com.example.liudao.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import com.example.liudao.domain.repositories.ExerciseRepository
import com.example.liudao.domain.interfaces.IExerciseRepository
import com.example.liudao.domain.interfaces.IMuscleGroupRepository
import com.example.liudao.domain.repositories.MuscleGroupRepository

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun bindExerciseRepository(
        exerciseRepoImpl: ExerciseRepository
    ): IExerciseRepository

    @Binds
    abstract fun bindMuscleGroupRepository(
        muscleGroupRepoImpl: MuscleGroupRepository
    ): IMuscleGroupRepository

}