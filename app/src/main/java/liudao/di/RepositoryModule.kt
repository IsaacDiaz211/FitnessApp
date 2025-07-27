package liudao.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import liudao.domain.repositories.ExerciseRepository
import liudao.domain.interfaces.IExerciseRepository
import liudao.domain.interfaces.IMuscleGroupRepository
import liudao.domain.interfaces.IRoutineRepository
import liudao.domain.interfaces.ISetRepository
import liudao.domain.interfaces.ISupplementRepository
import liudao.domain.repositories.MuscleGroupRepository
import liudao.domain.repositories.RoutineRepository
import liudao.domain.repositories.SetRepository
import liudao.domain.repositories.SupplementRepository

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