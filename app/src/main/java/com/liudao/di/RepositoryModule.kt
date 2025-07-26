package com.example.liudao.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import com.example.liudao.domain.repositories.ExerciseRepository
import com.example.liudao.domain.interfaces.IExerciseRepository
import com.example.liudao.domain.interfaces.IMuscleGroupRepository
import com.example.liudao.domain.interfaces.IRoutineRepository
import com.example.liudao.domain.interfaces.ISetRepository
import com.example.liudao.domain.interfaces.ISupplementRepository
import com.example.liudao.domain.repositories.MuscleGroupRepository
import com.example.liudao.domain.repositories.RoutineRepository
import com.example.liudao.domain.repositories.SetRepository
import com.example.liudao.domain.repositories.SupplementRepository

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

    @Binds
    abstract fun bindRoutineRepository(
        routineRepoImpl: RoutineRepository
    ): IRoutineRepository

    @Binds
    abstract fun bindSetRepository(
        setRepoImpl: SetRepository
    ): ISetRepository

    @Binds
    abstract fun bindSupplementRepository(
        supRepoImpl: SupplementRepository
    ): ISupplementRepository
}